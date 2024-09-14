package com.example.core_data.repo

import android.util.Log
import com.example.core_auth_api.repository.AuthRepository
import com.example.core_network.api.AuthApi
import com.example.core_network.dto.dtoe.AuthDTOE
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authApi: AuthApi,
) : AuthRepository {
    override suspend fun sendAuth() {
        runCatching {
            val response = authApi.sendAuth(AuthDTOE("+79997568844"))
            if (response.isSuccessful) {
                response.body()?.let { item ->
                    item.isSuccess
                }
            } else {
                Log.d("AuthApiError", response.message().toString())
            }
        }.onFailure { Log.d("AuthApiError", "Failed to fetch data: ${it.message}") }
    }
}