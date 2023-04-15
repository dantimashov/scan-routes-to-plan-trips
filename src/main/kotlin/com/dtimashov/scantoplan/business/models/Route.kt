package com.dtimashov.scantoplan.business.models

import com.dtimashov.scantoplan.utils.DurationSerializer
import com.dtimashov.scantoplan.utils.LocalTimeSerializer
import kotlinx.serialization.Serializable
import java.time.Duration
import java.time.LocalTime

/**
 * @author daniil.timashov on 25.02.2023
 */
@Serializable
data class Route(val departure: Place, val arrival: Place, val price: Int,
                 @Serializable(with = LocalTimeSerializer::class)  val departureTime: LocalTime,
                 @Serializable(with = LocalTimeSerializer::class) val arrivalTime: LocalTime,
                 @Serializable(with = DurationSerializer::class) val duration: Duration)
