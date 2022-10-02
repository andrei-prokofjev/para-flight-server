package com.apro.paraglide.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RegisterRequest(
    @SerialName("user_name") val userName: String
)

@Serializable
data class RegisterResponse(
    @SerialName("user_id") val userId: String
)