package com.example.core_database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.core_database.entity.UserEntity

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(profile: UserEntity)

    @Query("SELECT * FROM user_table ORDER BY created_at DESC LIMIT 1 ")
    suspend fun getActiveUser(): UserEntity?
}