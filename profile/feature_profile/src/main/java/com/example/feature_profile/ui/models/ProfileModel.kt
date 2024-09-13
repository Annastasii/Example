package com.example.feature_profile.ui.models

data class ProfileModel(
    val name: String,
    val username: String,
    val birthday: String,
    val city: String,
    val aboutMe: String,
    val avatar: FileModel,
)