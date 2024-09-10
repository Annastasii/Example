package com.example.core_database.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.core_database.dao.MessageDao
import com.example.core_database.entity.MessageEntity

@Database(entities = [MessageEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun messageDao(): MessageDao
}