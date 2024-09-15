package com.example.core_network.api

import com.example.core_network.dto.dtoe.ProfileDTOE
import com.example.core_network.dto.dtoi.AvatarDTOI
import com.example.core_network.dto.dtoi.ProfileResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT

interface ProfileApi {

    @GET("api/v1/users/me")
    suspend fun getProfile(): Response<ProfileResponse>

    @PUT("api/v1/users/me")
    suspend fun putProfile(@Body profile: ProfileDTOE): Response<AvatarDTOI>
}