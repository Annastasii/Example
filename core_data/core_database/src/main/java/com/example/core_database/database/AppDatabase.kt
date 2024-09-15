package com.example.core_database.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.core_database.dao.MessageDao
import com.example.core_database.dao.ProfileDao
import com.example.core_database.entity.FileEntity
import com.example.core_database.entity.MessageEntity
import com.example.core_database.entity.ProfileEntity

@Database(entities = [MessageEntity::class, ProfileEntity::class, FileEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun messageDao(): MessageDao
    abstract fun profileDao(): ProfileDao
}