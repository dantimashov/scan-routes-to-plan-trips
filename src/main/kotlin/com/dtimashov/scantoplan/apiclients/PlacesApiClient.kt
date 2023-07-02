package com.dtimashov.scantoplan.apiclients

import com.dtimashov.scantoplan.business.models.Place

/**
 * @author daniil.timashov on 21.05.2023
 */
interface PlacesApiClient {

    fun placeById(id: String): Place

    fun subplaces(parentPlace: Place): Set<Place>

}
