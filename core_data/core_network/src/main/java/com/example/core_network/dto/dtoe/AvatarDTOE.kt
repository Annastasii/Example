package com.example.core_network.dto.dtoe

import com.squareup.moshi.Json

data class AvatarDTOE(
    @Json(name = "filename")
    val filename: String,

    @Json(name = "base_64")
    val base64: String,
)