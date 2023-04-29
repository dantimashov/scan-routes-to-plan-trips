package com.dtimashov.scantoplan.apiclients.tequila.clients

import com.dtimashov.scantoplan.apiclients.tequila.beans.SearchData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

/**
 * @author daniil.timashov on 23.04.2023
 */
interface SearchClient {

    @GET("v2/search")
    fun search(@QueryMap params: Map<String, String>): Call<SearchData>
}
