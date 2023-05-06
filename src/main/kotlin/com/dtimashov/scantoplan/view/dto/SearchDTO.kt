package com.dtimashov.scantoplan.view.dto

import com.dtimashov.scantoplan.utils.LocalDateSerializer
import kotlinx.serialization.Serializable
import java.time.LocalDate

/**
 * @author daniil.timashov on 06.05.2023
 */

@Serializable
data class SearchDTO(val departureId: String, val destinationId: String,
                     @Serializable(with = LocalDateSerializer::class)  val fromDate: LocalDate,
                     @Serializable(with = LocalDateSerializer::class)  val toDate: LocalDate,
                     val filters: FiltersDTO)
