package com.apro.paraglide.config

import com.apro.paraglide.data.RegisterRequest
import io.ktor.server.plugins.*
import io.ktor.server.plugins.requestvalidation.*

fun RequestValidationConfig.requestValidationConfig() {
    validate<RegisterRequest> { request ->
        with(request) {
            when {
                userName == "aaa" -> throw BadRequestException("name already exists")
                userName.isEmpty() -> throw BadRequestException("user name is empty")
                userName.length < 3 -> throw BadRequestException("too short name")
                userName.length > 20 -> throw BadRequestException("too long name")
                else -> ValidationResult.Valid
            }
        }
    }
}
