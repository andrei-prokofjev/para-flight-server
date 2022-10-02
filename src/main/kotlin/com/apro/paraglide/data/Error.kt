package com.apro.paraglide.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ErrorMessage(
    @SerialName("message") val message: String?,
    @SerialName("code") val code: Int = 0,
)

