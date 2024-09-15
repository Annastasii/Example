package com.example.core_database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "profile")
data class ProfileEntity(
    val name: String,
    val username: String,
    val birthday: String?,
    val city: String?,
    val vk: String?,
    val instagram: String?,
    val status: String?,
    val avatar: String?,
    @PrimaryKey
    val id: Int,
    val last: String?,
    val online: Boolean,
    val created: String?,
    val phone: String,
    val completedTask: Int,
)