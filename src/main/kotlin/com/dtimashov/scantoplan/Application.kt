package com.dtimashov.scantoplan

import com.dtimashov.scantoplan.view.dto.FiltersDTO
import com.dtimashov.scantoplan.view.routesRouting
import com.dtimashov.scantoplan.view.validateFilters
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.plugins.requestvalidation.*
import kotlinx.serialization.json.Json

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    routesRouting()
    install(ContentNegotiation) {
        json(Json {
            prettyPrint = true
            isLenient = true
        })
    }
    install(RequestValidation) {
        validate(FiltersDTO::class, ::validateFilters)
    }
}
