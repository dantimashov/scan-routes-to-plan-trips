package com.dtimashov.scantoplan.apiclients.tequila

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
 * @author daniil.timashov on 29.04.2023
 */

fun toTequilaDateFormat(date: LocalDate): String {
    return date.format(DateTimeFormatter.ofPattern("YYYY-MM-dd"))
}

fun fromTequilaDateFormat(date: String): LocalDateTime {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS")
    return LocalDateTime.parse(date.replace("Z", ""), formatter)
}
