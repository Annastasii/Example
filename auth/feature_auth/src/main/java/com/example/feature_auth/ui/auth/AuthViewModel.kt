package com.example.feature_auth.ui.auth

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_auth_api.repository.AuthRepository
import com.example.core_network.api.AuthApi
import com.example.core_network.dto.dtoe.AuthDTOE
import com.example.feature_auth.ui.auth.model.Flags
import com.example.feature_auth.ui.auth.model.NavScreen
import com.example.feature_auth.ui.auth.model.ScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
//    private val repository: AuthRepository,
    private val authApi: AuthApi,
) : ViewModel() {

    val screenState: StateFlow<ScreenState> get() = _screenState.asStateFlow()
    private val _screenState = MutableStateFlow<ScreenState>(ScreenState())

    val phoneNumber = MutableStateFlow<String>("")

    val code = MutableStateFlow<String>("")

    fun onChangeCode(value: String) {
        code.value = value
    }

    fun authorization(phone: String) {
        viewModelScope.launch {
            _screenState.update { it.copy(isProgress = true) }
            runCatching {
                val response = authApi.sendAuth(AuthDTOE(phone))
                if (response.isSuccessful) {
                    response.body()?.let { item ->
                        _screenState.update { it.copy(isSuccess = item.isSuccess) }
                    }
                } else {
                    Log.d("AuthApiError", response.message().toString())
                }
            }.onFailure { error ->
                _screenState.update { it.copy(isProgress = false) }
                Log.d("AuthApiError", "Failed to fetch data: ${error.message}")
            }
                .onSuccess { _screenState.update { it.copy(isProgress = false) } }
        }
    }

    fun onChangeFlag(flag: Flags) {
        _screenState.update { it.copy(flags = flag) }
        code.value = flag.code
    }

    fun onChangeNumber(value: String) {
        phoneNumber.value = value
    }
}