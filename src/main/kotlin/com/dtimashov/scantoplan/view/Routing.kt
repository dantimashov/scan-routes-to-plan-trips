package com.dtimashov.scantoplan.view

import com.dtimashov.scantoplan.application.FlightsFromCityModule
import com.dtimashov.scantoplan.business.services.RouteFilters
import com.dtimashov.scantoplan.view.dto.FiltersDTO
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*
import io.ktor.server.plugins.requestvalidation.*
import io.ktor.server.request.*

fun Application.routesRouting() {

    routing {

        fun setFiltersIfExist(filtersBuilder:  RouteFilters.Builder, requestBody: FiltersDTO) {
            requestBody.price?.let {
                filtersBuilder.byPrice(it.min!!, it.max!!)
            }
            requestBody.duration?.let {
                filtersBuilder.byDuration(it.min!!, it.max!!)
            }
            requestBody.departureTime?.let {
                filtersBuilder.byDepartureTime(it.from!!, it.to!!)
            }
        }

        post("/routes") {
            val requestBody = call.receive<FiltersDTO>()
            val flightsFromCityModule = FlightsFromCityModule()
            val filtersBuilder = RouteFilters().Builder()
            setFiltersIfExist(filtersBuilder, requestBody)
            call.respond(flightsFromCityModule.routesByFilter(filtersBuilder.build()))
        }

    }


}

fun validateFilters(body: FiltersDTO): ValidationResult {
    val onlyOneIsNull = {a: Any?, b: Any? -> (a == null) || (b == null)}
    val requiredDataMissedInFilter = {
            filter: Any?, filterData1: Any?,  filterData2: Any? -> filter != null && onlyOneIsNull(filterData1, filterData2)
    }

    if(requiredDataMissedInFilter(body.duration, body.duration?.min, body.duration?.max))
        return ValidationResult.Invalid("Duration field should contains both `min` and `max` values")
    if(requiredDataMissedInFilter(body.departureTime, body.departureTime?.from, body.departureTime?.to))
        return ValidationResult.Invalid("Departure time field should contains both `from` and `to` values")
    if(requiredDataMissedInFilter(body.price, body.price?.min, body.price?.max))
        return ValidationResult.Invalid("Price field should contains both `min` and `max` max")
    return ValidationResult.Valid
}

