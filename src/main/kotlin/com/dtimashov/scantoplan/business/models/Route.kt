package com.dtimashov.scantoplan.business.models

import com.dtimashov.scantoplan.utils.DurationSerializer
import com.dtimashov.scantoplan.utils.LocalDateTimeSerializer
import kotlinx.serialization.Serializable
import java.time.Duration
import java.time.LocalDateTime

/**
 * @author daniil.timashov on 25.02.2023
 */
@Serializable
data class Route(val departure: Place, val arrival: Place, val price: Int,
                 @Serializable(with = LocalDateTimeSerializer::class)  val departureTime: LocalDateTime,
                 @Serializable(with = LocalDateTimeSerializer::class) val arrivalTime: LocalDateTime,
                 @Serializable(with = DurationSerializer::class) val duration: Duration)
