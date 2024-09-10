package com.example.feature_auth.ui.pin_code

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.core_navigation.route.PinCodeDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class PinCodeViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    var phone = savedStateHandle.get<String>(PinCodeDestination.PHONE)!!

    val pin = MutableStateFlow<String>("")

    fun enterPin(value: String) {
        pin.value = value
    }
}