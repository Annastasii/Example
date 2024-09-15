package com.example.core_network.dto.dtoe

import com.squareup.moshi.Json

data class RegisterDTOE(
    @Json(name = "phone")
    val phone: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "username")
    val username: String,
)