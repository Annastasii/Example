package com.example.core_database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "file")
data class FileEntity(
    @PrimaryKey
    val id: Int,
    val parentId: Int,
    val avatar: String,
    val bigAvatar: String,
    val miniAvatar: String
)
