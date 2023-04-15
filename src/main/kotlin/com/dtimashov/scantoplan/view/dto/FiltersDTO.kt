package com.dtimashov.scantoplan.view.dto

import com.dtimashov.scantoplan.utils.DurationSerializer
import com.dtimashov.scantoplan.utils.LocalTimeSerializer
import kotlinx.serialization.*
import java.time.Duration
import java.time.LocalTime

/**
 * @author daniil.timashov on 12.03.2023
 */
@Serializable
data class FiltersDTO(val price: PriceDto? = null, val duration: DurationDto? = null, val departureTime: DepartureTimeDto? = null)

@Serializable
data class PriceDto(val min: Int? = null, val max: Int? = null)

@Serializable
data class DurationDto(
    @Serializable(with = DurationSerializer::class) val min: Duration? = null,
    @Serializable(with = DurationSerializer::class) val max: Duration? = null
)

@Serializable
data class DepartureTimeDto(
    @Serializable(with = LocalTimeSerializer::class) val from: LocalTime? = null,
    @Serializable(with = LocalTimeSerializer::class) val to: LocalTime? = null
)
