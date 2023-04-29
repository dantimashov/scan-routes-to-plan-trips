package com.dtimashov.scantoplan.apiclients.tequila.beans

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @author daniil.timashov on 16.04.2023
 */

@Serializable
data class SearchData (
    val data: List<Search>
)

@Serializable
data class Search (
    val flyFrom: String, val flyTo: String,
    val cityFrom: String, val cityCodeFrom: String, val cityTo: String, val cityCodeTo: String,
    val countryFrom: SearchCountry, val countryTo: SearchCountry,
    val price: Int, val airlines: List<String>,
    @SerialName("local_arrival") val localArrival: String, @SerialName("utc_arrival") val utcArrival: String,
    @SerialName("local_departure") val localDeparture: String, @SerialName("utc_departure") val utcDeparture: String,
    val duration: SearchDuration
    )

@Serializable
data class SearchCountry (val code: String, val name: String)

@Serializable
data class SearchDuration (@SerialName("total") val totalSeconds: Int)



