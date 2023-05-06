package com.dtimashov.scantoplan.application

import com.dtimashov.scantoplan.apiclients.RoutesApiClient
import com.dtimashov.scantoplan.apiclients.RoutesApiClientImpl
import com.dtimashov.scantoplan.business.models.Route
import com.dtimashov.scantoplan.business.models.RoutesSearch
import com.dtimashov.scantoplan.business.services.RouteFilters

/**
 * @author daniil.timashov on 27.02.2023
 */
class FlightsFromCityModule {

    fun routesByFilter(query : RoutesSearch, filterService: RouteFilters): List<Route> {
        val client: RoutesApiClient = RoutesApiClientImpl()
        val routes = client.search(query.departure, query.destination, query.fromDate, query.toDate)
        return filterService.filter(routes)
    }

}
