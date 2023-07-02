package com.dtimashov.scantoplan.apiclients

import okhttp3.Request
import retrofit2.Call

/**
 * @author daniil.timashov on 02.06.2023
 */
open class BaseApiClient {

    protected fun <T> withSuccessfulResult(call: Call<T>) : T {
        val response = call.execute()
        if (response.isSuccessful) {
            return response.body() ?: throw ExternalApiException("External api response body is null\n", call.request())
        }
        throw ExternalApiException("External api has responded with HTTP status code ${response.code()}\n", call.request())
    }

    class ExternalApiException(message: String? = null, cause: Throwable? = null) : Exception(message, cause) {
        constructor(message: String, request: Request) : this(message + httpRequestInfo(request), null)
    }
}

fun httpRequestInfo(request: Request): String {
    return """
        Url: "${request.url()}"
        Headers: "${request.headers()}"
    """.trimIndent()
}
