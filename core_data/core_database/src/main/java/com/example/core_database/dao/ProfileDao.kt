package com.example.core_database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.core_database.entity.ProfileEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProfileDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(profile: ProfileEntity)

    @Query("SELECT * FROM profile WHERE id == :id")
    fun getProfileFlow(id: Int): Flow<ProfileEntity?>

    @Query("UPDATE profile SET birthday = :birthday, city = :city, instagram = :instagram WHERE id ==:id")
    suspend fun updateProfile(birthday: String?, city: String?, instagram: String?, id: Int)
}