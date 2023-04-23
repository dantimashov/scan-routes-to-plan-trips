package com.dtimashov.scantoplan.business.services

import com.dtimashov.scantoplan.business.models.Place
import com.dtimashov.scantoplan.business.models.Route
import java.time.Duration
import java.time.LocalTime

/**
 * @author daniil.timashov on 25.02.2023
 */
class RouteFilters {

    private lateinit var filters: MutableList<(Route) -> Boolean>

    fun filter(routes: List<Route>): List<Route> {
        return routes.filter { route -> filters.all { check -> check(route) } }
    }

    inner class Builder() {

        init {
            filters = mutableListOf()
        }

        fun byDuration(min : Duration, max: Duration) = apply { filters.add {
                route -> route.duration in min..max
        }}

        fun byDepartureTime(from : LocalTime, to: LocalTime) = apply { filters.add {
                route -> route.departureTime.toLocalTime().isAfter(from) && route.departureTime.toLocalTime().isBefore(to)
        }}

        fun byPrice(min : Int, max: Int) = apply { filters.add {
                route -> route.price in min until max + 1
        }}

        fun excludePlaces(places: List<Place>) = apply { filters.add {
            route -> places.none{excludePlace -> route.departure == excludePlace || route.arrival == excludePlace }
        }}

        fun build(): RouteFilters {
            return this@RouteFilters
        }

    }

}
