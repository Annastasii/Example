package com.example.core_database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class UserEntity(
    @PrimaryKey
    val id: Int,
    val isActive: Boolean,
    @ColumnInfo(name = "created_at") val createdAt: Long = System.currentTimeMillis()
)
