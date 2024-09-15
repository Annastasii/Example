package com.example.feature_auth.ui.register

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_auth_api.AuthTokenProvider
import com.example.core_navigation.route.RegisterDestination
import com.example.core_network.api.AuthApi
import com.example.core_network.dto.dtoe.RegisterDTOE
import com.example.feature_auth.ui.register.model.ScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val authApi: AuthApi,
    private val authTokenProvider: AuthTokenProvider,
) : ViewModel() {

    var phone = savedStateHandle.get<String>(RegisterDestination.PHONE)!!

    val name = MutableStateFlow<String>("")

    val username = MutableStateFlow<String>("")

    val screenState: StateFlow<ScreenState> get() = _screenState.asStateFlow()
    private val _screenState = MutableStateFlow<ScreenState>(ScreenState())

    fun onChangeName(value: String) {
        name.value = value
    }

    fun onChangeUsername(value: String) {
        username.value = value
    }

    fun showMessage(value: Boolean) {
        _screenState.update { it.copy(showMessage = value) }
    }

    fun register() {
        viewModelScope.launch {
            runCatching {
                val response = authApi.register(
                    RegisterDTOE(
                        phone = phone,
                        name = name.value,
                        username = username.value
                    )
                )
                if (response.isSuccessful) {
                    response.body()?.let { item ->
                        _screenState.update { it.copy(userId = item.userId) }
                        authTokenProvider.saveAccessToken(item.accessToken)
                        authTokenProvider.saveRefreshToken(item.refreshToken)
                    }
                } else {
                    if (response.code() == 402) {
                        _screenState.update { it.copy(incorrectName = true) }
                    }
                    Log.d("AuthApiError", response.toString())
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
           _screenState.update { it.copy(userId = null) }
        }
    }
}