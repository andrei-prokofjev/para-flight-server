package com.apro.paraglide.plugins

import com.apro.paraglide.data.RegisterRequest
import com.apro.paraglide.data.RegisterResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.util.*

fun Application.registerRouting() {

    routing {
        get("/") { call.respondText("OK!") }

        post("/api/v1/register") {
            call.receive<RegisterRequest>()
            call.respond(HttpStatusCode.OK, RegisterResponse(UUID.randomUUID().toString()))
        }
    }

}


