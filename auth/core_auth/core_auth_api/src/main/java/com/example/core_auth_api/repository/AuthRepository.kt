package com.example.core_auth_api.repository

interface AuthRepository {

    suspend fun sendAuth()
}