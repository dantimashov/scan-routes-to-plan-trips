package com.dtimashov.scantoplan.business.models

import com.dtimashov.scantoplan.utils.LocalDateSerializer
import kotlinx.serialization.Serializable
import java.time.LocalDate

/**
 * @author daniil.timashov on 06.05.2023
 */
@Serializable
data class RoutesSearch(val departure: Place, val destination: Place,
                        @Serializable(with = LocalDateSerializer::class) val fromDate: LocalDate,
                        @Serializable(with = LocalDateSerializer::class) val toDate: LocalDate
)
