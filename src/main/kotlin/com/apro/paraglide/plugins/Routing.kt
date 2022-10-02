package com.apro.paraglide.plugins

import com.apro.paraglide.data.RegisterRequest
import com.apro.paraglide.data.RegisterResponse
import com.apro.paraglide.database.UserService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.util.*

fun Application.registerRouting(userService: UserService) {

    routing {
        get("/") { call.respondText("OK!") }

        post("/api/v1/register") {

            println(">>> total users: " + userService.getAllUsers().size)
            val request = call.receive<RegisterRequest>()
            userService.insertUser(request.userName)
            call.respond(HttpStatusCode.OK, RegisterResponse(UUID.randomUUID().toString()))
        }
    }

}


