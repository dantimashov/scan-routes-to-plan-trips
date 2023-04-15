package com.dtimashov.scantoplan.application

import com.dtimashov.scantoplan.business.models.Route
import com.dtimashov.scantoplan.business.services.RouteFilters

/**
 * @author daniil.timashov on 27.02.2023
 */
class FlightsFromCityModule {

    fun routesByFilter(filterService: RouteFilters): List<Route> {
        val routes = listOf<Route>() // TODO implement getting and filtering data
        return filterService.filter(routes)
    }

}
