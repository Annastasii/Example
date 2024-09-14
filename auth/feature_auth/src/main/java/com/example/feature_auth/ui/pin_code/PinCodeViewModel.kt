package com.example.feature_auth.ui.pin_code

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_navigation.route.PinCodeDestination
import com.example.core_network.api.AuthApi
import com.example.core_network.dto.dtoe.AuthDTOE
import com.example.core_network.dto.dtoe.CheckAuthDTOE
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PinCodeViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val authApi: AuthApi,
) : ViewModel() {

    var phone = savedStateHandle.get<String>(PinCodeDestination.PHONE)!!

    val pin = MutableStateFlow<String>("")

    fun enterPin(value: String) {
        pin.value = value
    }

    fun checkPin() {
//        viewModelScope.launch {
//            runCatching {
//                val response = authApi.checkAuth(CheckAuthDTOE(phone, phone.substring(0, 1)))
//                if (response.isSuccessful) {
//                    response.body()?.let { item ->
//                        _screenState.update { it.copy(isSuccess = item.isSuccess) }
//                    }
//                } else {
//                    Log.d("AuthApiError", response.message().toString())
//                }
//            }.onFailure { error ->
//                Log.d("AuthApiError", "Failed to fetch data: ${error.message}")
//            }
//        }
    }
}