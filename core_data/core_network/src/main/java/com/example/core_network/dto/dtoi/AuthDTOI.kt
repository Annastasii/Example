package com.example.core_network.dto.dtoi

import com.squareup.moshi.Json

data class AuthDTOI(
    @Json(name = "is_success")
    val isSuccess: Boolean,
)