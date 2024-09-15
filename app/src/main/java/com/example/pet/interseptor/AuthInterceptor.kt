package com.example.pet.interseptor

import com.example.core_auth_api.AuthTokenProvider
import com.example.core_network.api.AuthApi
import com.example.core_network.dto.dtoe.RefreshTokenDTOE
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Provider

class AuthInterceptor @Inject constructor(
    private val authTokenProvider: AuthTokenProvider,
    private val apiService: Provider<AuthApi>
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()

        // Добавляем токен, если не находимся на маршрутах без авторизации
        if (requiresAuth(request.url)) {
            val token = authTokenProvider.getAccessToken()
            request = request.newBuilder()
                .addHeader("Authorization", "Bearer $token")
                .build()
        }

        // Выполняем запрос
        val response = chain.proceed(request)

        // Если получаем 401, обновляем токен
        if (response.code == 401) {
            synchronized(this) {
                val newToken = refreshAccessToken()
                if (newToken != null) {
                    authTokenProvider.saveAccessToken(newToken)

                    // Повторяем запрос с новым токеном
                    val newRequest = request.newBuilder()
                        .header("Authorization", "Bearer $newToken")
                        .build()

                    return chain.proceed(newRequest)
                }
            }
        }

        return response
    }

    private fun requiresAuth(url: HttpUrl): Boolean {
        val unprotectedPaths = listOf(
            "/api/v1/users/register/",
            "/api/v1/users/send-auth-code/",
            "/api/v1/users/check-auth-code/"
        )
        return !unprotectedPaths.any { url.encodedPath.contains(it) }
    }

    private fun refreshAccessToken(): String? {
        val refreshToken = authTokenProvider.getRefreshToken()
        val refreshResponse = apiService.get().refreshToken(RefreshTokenDTOE(refreshToken!!))
        return if (refreshResponse.isSuccessful) {
            refreshResponse.body()?.accessToken
        } else {
            null
        }
    }
}