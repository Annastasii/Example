package com.example.core_network.api

import com.example.core_network.dto.dtoe.AuthDTOE
import com.example.core_network.dto.dtoe.CheckAuthDTOE
import com.example.core_network.dto.dtoe.RefreshTokenDTOE
import com.example.core_network.dto.dtoe.RegisterDTOE
import com.example.core_network.dto.dtoi.AuthDTOI
import com.example.core_network.dto.dtoi.RefreshTokenDTOI
import com.example.core_network.dto.dtoi.SuccessAuthDTOI
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST("api/v1/users/send-auth-code/")
    suspend fun sendAuth(@Body auth: AuthDTOE): Response<AuthDTOI>

    @POST("docs#/api/v1/users/check-auth-code/")
    suspend fun checkAuth(@Body auth: CheckAuthDTOE): Response<SuccessAuthDTOI>

    @POST("docs#/api/v1/users/register/")
    suspend fun register(@Body auth: RegisterDTOE): Response<SuccessAuthDTOI>

    @POST("docs#/api/v1/users/fefresh-token/")
     fun refreshToken(@Body auth: RefreshTokenDTOE): Response<RefreshTokenDTOI>

    data class TokenResponse(
        val accessToken: String,
        val refreshToken: String
    )
}