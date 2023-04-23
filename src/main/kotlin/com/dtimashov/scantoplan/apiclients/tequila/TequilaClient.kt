package com.dtimashov.scantoplan.apiclients.tequila

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.*

/**
 * @author daniil.timashov on 23.04.2023
 */
class TequilaClient {

    object ClientConfig {

        private val clientProperties = Properties()

        init {
            clientProperties.load(this::class.java.classLoader.getResourceAsStream("tequila_client.properties"))
        }

        val TOKEN = getConfigProperty("token")
        val HOST = getConfigProperty("host")

        private fun getConfigProperty(key: String): String {
            return clientProperties.getProperty(key) ?: throw RuntimeException("Not found property with name '$key'")
        }
    }

    object ClientProvider {
        private val clientWithApiKey: OkHttpClient = OkHttpClient.Builder().addInterceptor { chain ->
            val requestWithApiKey = chain.request().newBuilder()
                .addHeader("apikey", ClientConfig.TOKEN)
                .build()
            chain.proceed(requestWithApiKey)
        }.build()
        val client: Retrofit = Retrofit.Builder()
            .baseUrl(ClientConfig.HOST)
            .client(clientWithApiKey)
            .addConverterFactory(Json.asConverterFactory(MediaType.get("application/json")))
            .build()
    }
}
