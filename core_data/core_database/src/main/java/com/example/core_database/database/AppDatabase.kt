package com.example.core_database.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.core_database.dao.MessageDao
import com.example.core_database.dao.ProfileDao
import com.example.core_database.dao.UserDao
import com.example.core_database.entity.FileEntity
import com.example.core_database.entity.MessageEntity
import com.example.core_database.entity.ProfileEntity
import com.example.core_database.entity.UserEntity

@Database(entities = [MessageEntity::class, ProfileEntity::class, FileEntity::class, UserEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun messageDao(): MessageDao
    abstract fun profileDao(): ProfileDao
    abstract fun userDao(): UserDao
}