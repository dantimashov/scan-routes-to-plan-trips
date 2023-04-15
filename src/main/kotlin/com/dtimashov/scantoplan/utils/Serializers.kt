package com.dtimashov.scantoplan.utils

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializer
import kotlinx.serialization.encoding.Decoder
import java.time.Duration
import java.time.LocalTime
import java.time.format.DateTimeFormatter

/**
 * @author daniil.timashov on 15.04.2023
 */

@OptIn(ExperimentalSerializationApi::class)
@Serializer(forClass = LocalTime::class)
object LocalTimeSerializer : KSerializer<LocalTime> {

    private val applicationTimeFormat: DateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm")

    override fun deserialize(decoder: Decoder): LocalTime {
        return LocalTime.parse(decoder.decodeString(), applicationTimeFormat)
    }

    override fun serialize(encoder: kotlinx.serialization.encoding.Encoder, value: LocalTime) {
        encoder.encodeString(value.format(applicationTimeFormat))
    }
}

@OptIn(ExperimentalSerializationApi::class)
@Serializer(forClass = Duration::class)
object DurationSerializer : KSerializer<Duration> {

    override fun deserialize(decoder: Decoder): Duration {
        return Duration.parse(decoder.decodeString())
    }

    override fun serialize(encoder: kotlinx.serialization.encoding.Encoder, value: Duration) {
        encoder.encodeString(value.toString())
    }
}
