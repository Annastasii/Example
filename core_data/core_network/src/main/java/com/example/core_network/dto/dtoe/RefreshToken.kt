package com.example.core_network.dto.dtoe

import com.squareup.moshi.Json

data class RefreshTokenDTOE(
    @Json(name = "refresh_token")
    val refreshToken: String,
)
