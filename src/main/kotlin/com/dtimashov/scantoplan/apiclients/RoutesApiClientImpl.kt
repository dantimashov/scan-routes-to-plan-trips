package com.dtimashov.scantoplan.apiclients

import com.dtimashov.scantoplan.apiclients.tequila.TequilaClient
import com.dtimashov.scantoplan.apiclients.tequila.clients.SearchClient
import com.dtimashov.scantoplan.apiclients.tequila.fromTequilaDateFormat
import com.dtimashov.scantoplan.apiclients.tequila.toTequilaDateFormat
import com.dtimashov.scantoplan.business.models.Place
import com.dtimashov.scantoplan.business.models.Route
import retrofit2.Call
import java.time.Duration
import java.time.LocalDate

/**
 * @author daniil.timashov on 04.03.2023
 */
class RoutesApiClientImpl : RoutesApiClient {

    private val searchClient: SearchClient = TequilaClient.ClientProvider.client.create(SearchClient::class.java)

    override fun search(departure: Place, destination: Place, fromDate: LocalDate, toDate: LocalDate): List<Route> {
        val params = mapOf(
            "fly_from" to departure.id, "fly_to" to destination.id,
            "date_from" to toTequilaDateFormat(fromDate),"date_to" to toTequilaDateFormat(toDate),
            "max_stopovers" to "0", "limit" to "300")
        return withSuccessfulResult(searchClient.search(params)).data.map {
            Route(
                Place(it.cityCodeFrom, it.cityFrom, null), Place(it.cityCodeTo, it.cityTo, null), it.price,
                fromTequilaDateFormat(it.localDeparture), fromTequilaDateFormat(it.localArrival),
                Duration.ofSeconds(it.duration.totalSeconds.toLong())
            ) }
    }

    private fun <T> withSuccessfulResult(call: Call<T>) : T {
        return call.execute().body()!! // TODO handle IOException and empty body
    }

}
