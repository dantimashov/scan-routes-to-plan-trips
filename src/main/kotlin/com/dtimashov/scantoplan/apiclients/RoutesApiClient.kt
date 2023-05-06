package com.dtimashov.scantoplan.apiclients

import com.dtimashov.scantoplan.business.models.Place
import com.dtimashov.scantoplan.business.models.Route
import java.time.LocalDate

/**
 * @author daniil.timashov on 27.02.2023
 */
interface RoutesApiClient {

    fun search(departure: Place, destination: Place, fromDate: LocalDate, toDate: LocalDate): List<Route>

}
