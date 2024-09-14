package com.example.core_network.dto.dtoi

import com.squareup.moshi.Json

data class SuccessAuthDTOI(
    @Json(name = "refresh_token")
    val refreshToken: String,
    @Json(name = "access_token")
    val accessToken: String,
    @Json(name = "user_id")
    val userId: Int,
    @Json(name = "is_user_exists")
    val isUserExist: Boolean,
)