package com.dtimashov.scantoplan.apiclients

import com.dtimashov.scantoplan.apiclients.tequila.TequilaClient
import com.dtimashov.scantoplan.apiclients.tequila.clients.LocationClient
import com.dtimashov.scantoplan.business.models.Place

/**
 * @author daniil.timashov on 21.05.2023
 */
class PlaceApiClientImpl : PlacesApiClient, BaseApiClient() {

    private val locationClient: LocationClient = TequilaClient.ClientProvider.client.create(LocationClient::class.java)

    override fun placeById(id: String): Place {
        val params = mapOf("id" to id)
        // TODO implement converting LocationData to Place
        withSuccessfulResult(locationClient.locationsById(params)).locations
        return Place("")
    }

    override fun subplaces(parentPlace: Place): Set<Place> {
        val params = mapOf("term" to "", "location_types" to "")
        // TODO implement converting LocationData to Place
        withSuccessfulResult(locationClient.locationsSubentity(params)).locations
        return emptySet()
    }
}
