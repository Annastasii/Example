package com.example.feature_auth.ui.auth

import androidx.lifecycle.ViewModel
import com.example.feature_auth.ui.auth.model.Flags
import com.example.feature_auth.ui.auth.model.ScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class AuthScreenViewModel @Inject constructor() : ViewModel() {

    val screenState: StateFlow<ScreenState> get() = _screenState.asStateFlow()
    private val _screenState = MutableStateFlow<ScreenState>(ScreenState())

    val phoneNumber = MutableStateFlow<String>("")

    val code = MutableStateFlow<String>("")

    fun onChangeCode(value: String) {
        code.value = value
    }

    fun onChangeFlag(flag: Flags) {
        _screenState.update { it.copy(flags = flag) }
        code.value = flag.code
    }

    fun onChangeNumber(value: String) {
        phoneNumber.value = value
    }
}