package com.apro.paraglide

import com.apro.paraglide.config.errorStatusPageConfig
import com.apro.paraglide.config.requestValidationConfig
import com.apro.paraglide.plugins.registerRouting
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.callloging.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.plugins.requestvalidation.*
import io.ktor.server.plugins.statuspages.*
import org.slf4j.event.Level

fun main() {
    embeddedServer(Netty, host = "127.0.0.1", port = 3001) {
        install(CallLogging) {
            level = Level.DEBUG
        }
        install(ContentNegotiation) {
            json()
        }

        install(StatusPages) {
            errorStatusPageConfig()
        }

        install(RequestValidation) {
            requestValidationConfig()
        }

//        DatabaseFactory.init()

//        val userService = UserService()

        registerRouting()

    }.start(wait = true)
}
