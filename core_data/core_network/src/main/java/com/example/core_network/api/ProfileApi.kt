package com.example.core_network.api

import com.example.core_network.dto.dtoi.ProfileResponse
import retrofit2.Response
import retrofit2.http.GET

interface ProfileApi {

    @GET("api/v1/users/me")
    suspend fun getProfile(): Response<ProfileResponse>
}