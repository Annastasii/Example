package com.example.feature_auth.ui.register

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.core_navigation.route.RegisterDestination
import com.example.feature_auth.ui.register.model.ScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
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
}