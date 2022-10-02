package com.apro.paraglide.config

import com.apro.paraglide.data.ErrorMessage
import io.ktor.http.*
import io.ktor.server.plugins.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*

fun StatusPagesConfig.errorStatusPageConfig() {
    exception<BadRequestException> { call, cause ->
        call.respond(status = HttpStatusCode.BadRequest, message = ErrorMessage(cause.message))
    }
    exception<Throwable> { call, cause ->
        call.respondText(text = cause.stackTraceToString(), status = HttpStatusCode.InternalServerError)
    }
}


