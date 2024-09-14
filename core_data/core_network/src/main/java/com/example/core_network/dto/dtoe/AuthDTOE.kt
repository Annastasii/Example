package com.example.core_network.dto.dtoe

import com.squareup.moshi.Json

data class AuthDTOE(
    @Json(name = "phone")
    val phone: String,
)
