package com.example.core_network.dto.dtoe

import com.squareup.moshi.Json

data class CheckAuthDTOE(
    @Json(name = "phone")
    val phone: String,
    @Json(name = "code")
    val code: String,
)
