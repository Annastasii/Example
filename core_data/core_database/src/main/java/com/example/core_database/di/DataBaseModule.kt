package com.example.core_database.di

import android.content.Context
import androidx.room.Room
import com.example.core_database.dao.MessageDao
import com.example.core_database.dao.ProfileDao
import com.example.core_database.dao.UserDao
import com.example.core_database.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Suppress("TooManyFunctions")
@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "app_data"
        )
//            .allowMainThreadQueries()
            .build()
    }

    @Provides
    fun provideMessageDao(database: AppDatabase): MessageDao {
        return database.messageDao()
    }

    @Provides
    fun provideProfileDao(database: AppDatabase): ProfileDao {
        return database.profileDao()
    }

    @Provides
    fun provideUserDao(database: AppDatabase): UserDao {
        return database.userDao()
    }

}