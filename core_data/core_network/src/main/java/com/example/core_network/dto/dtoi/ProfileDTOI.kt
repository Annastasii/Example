package com.example.core_network.dto.dtoi

import com.squareup.moshi.Json

data class ProfileResponse(
    @Json(name = "profile_data")
    val profileData: ProfileDTOI
)

data class ProfileDTOI(
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
    val avatar: String?,

    @Json(name = "id")
    val id: Int,

    @Json(name = "last")
    val last: String?,

    @Json(name = "online")
    val online: Boolean,

    @Json(name = "created")
    val created: String,

    @Json(name = "phone")
    val phone: String,

    @Json(name = "completed_task")
    val completedTask: Int,

    @Json(name = "avatars")
    val avatars: AvatarDTOI?
)

data class AvatarDTOI(
    @Json(name = "avatar")
    val avatar: String,

    @Json(name = "bigAvatar")
    val bigAvatar: String,

    @Json(name = "miniAvatar")
    val miniAvatar: String
)