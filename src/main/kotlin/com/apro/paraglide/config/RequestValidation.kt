package com.apro.paraglide.config

import com.apro.paraglide.data.RegisterRequest
import com.apro.paraglide.database.UserService
import io.ktor.server.plugins.*
import io.ktor.server.plugins.requestvalidation.*

fun RequestValidationConfig.registerValidationConfig(userService: UserService) {
    validate<RegisterRequest> { request ->
        with(request) {
            when {
                userName.isEmpty() -> throw BadRequestException("user name is empty")
                userName.length < 3 -> throw BadRequestException("too short name")
                userName.length > 20 -> throw BadRequestException("too long name")
                userService.getAllUsers()
                    .count { it.name == request.userName } != 0 -> throw BadRequestException("name already exists")
                else -> ValidationResult.Valid
            }
        }
    }
}
