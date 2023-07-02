package com.dtimashov.scantoplan.apiclients.tequila.beans

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @author daniil.timashov on 16.04.2023
 */

@Serializable
data class LocationData (
    val locations: List<Location>
)

@Serializable
abstract class Location {
    abstract val id: String
}

@Serializable
@SerialName("airport")
data class LocationAirport (
    override val id: String, val name: String, val code: String, val city: City
) : Location()

@Serializable
@SerialName("city")
data class LocationCity (
    override val id: String, val name: String, val code: String? = null,
    val country: Country, val region: Region, val continent: Continent
) : Location()

@Serializable
@SerialName("country")
data class LocationCountry (
    override val id: String, val name: String, val code: String,
    val region: Region, val continent: Continent
) : Location()

@Serializable
@SerialName("region")
data class LocationRegion (
    override val id: String, val name: String
) : Location()

@Serializable
@SerialName("continent")
data class LocationContinent (
    override val id: String, val name: String, val code: String
) : Location()

enum class LocationType {
    station, airport, bus_station,
    city, autonomous_territory, subdivision,
    country, region, continent
}

@Serializable
data class City (
    val id: String, val name: String, val code: String,
    val country: Country, val region: Region, val continent: Continent
)

@Serializable
data class Country (
    val id: String, val name: String, val code: String
)

@Serializable
data class Region (
    val id: String, val name: String
)

@Serializable
data class Continent (
    val id: String, val name: String, val code: String
)













