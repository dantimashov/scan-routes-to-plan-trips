package com.dtimashov.scantoplan.apiclients.tequila.clients

import com.dtimashov.scantoplan.apiclients.tequila.beans.LocationData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

/**
 * @author daniil.timashov on 21.05.2023
 */
interface LocationClient {

    @GET("locations/query")
    fun locationsByQuery(@QueryMap params: Map<String, String>): Call<LocationData>

    @GET("locations/id")
    fun locationsById(@QueryMap params: Map<String, String>): Call<LocationData>

    @GET("locations/subentity")
    fun locationsSubentity(@QueryMap params: Map<String, String>): Call<LocationData>
}
