package com.example.core_network.dto.dtoe

import com.squareup.moshi.Json

data class ProfileDTOE(
    @Json(name = "name")
    val name: String,

    @Json(name = "username")
    val username: String,

    @Json(name = "birthday")
    val birthday: String?,

    @Json(name = "city")
    val city: String?,

    @Json(name = "vk")
    val vk: String?,

    @Json(name = "instagram")
    val instagram: String?,

    @Json(name = "status")
    val status: String?,

    @Json(name = "avatar")
    val avatars: AvatarDTOE?
)
