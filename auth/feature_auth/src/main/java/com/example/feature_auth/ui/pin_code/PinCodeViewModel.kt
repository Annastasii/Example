package com.example.feature_auth.ui.pin_code

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_auth_api.AuthTokenProvider
import com.example.core_database.dao.UserDao
import com.example.core_database.entity.UserEntity
import com.example.core_navigation.route.PinCodeDestination
import com.example.core_network.api.AuthApi
import com.example.core_network.api.ProfileApi
import com.example.core_network.dto.dtoe.CheckAuthDTOE
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PinCodeViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val authApi: AuthApi,
    private val authTokenProvider: AuthTokenProvider,
    private val userDao: UserDao
) : ViewModel() {

    var phone = savedStateHandle.get<String>(PinCodeDestination.PHONE)!!

    val pin = MutableStateFlow<String>("")

    val userId = MutableStateFlow<Int?>(null)

    fun enterPin(value: String) {
        pin.value = value
    }

    fun checkPin() {
        viewModelScope.launch {
            runCatching {
                val response = authApi.checkAuth(CheckAuthDTOE(phone, pin.value))
                if (response.isSuccessful) {
                    response.body()?.let { item ->
                        userId.value = item.userId
                        authTokenProvider.saveAccessToken(item.accessToken)
                        authTokenProvider.saveRefreshToken(item.refreshToken)
                        userDao.insert(UserEntity(id = item.userId, isActive = true))
                    }
                } else {
                    Log.d("AuthApiError", response.message().toString())
                }
            }.onFailure { error ->
                Log.d("AuthApiError", "Failed to fetch data: ${error.message}")
            }
        }
    }

    fun deleteUserId(f: () -> Unit) {
        runCatching {
            f()
        }.onSuccess {
            userId.value = null
        }
    }
}