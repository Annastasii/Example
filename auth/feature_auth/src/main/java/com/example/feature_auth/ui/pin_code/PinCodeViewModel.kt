package com.example.feature_auth.ui.pin_code

//import androidx.lifecycle.SavedStateHandle
//import androidx.lifecycle.ViewModel
//import com.example.core_navigation.routes.PinCodeDestination
//import dagger.hilt.android.lifecycle.HiltViewModel
//import kotlinx.coroutines.flow.MutableStateFlow
//import javax.inject.Inject
//
//@HiltViewModel
//class PinCodeViewModel @Inject constructor(
//    savedStateHandle: SavedStateHandle,
//) : ViewModel() {
//
//    var email = savedStateHandle.get<String>(PinCodeDestination.EMAIL)!!
//
//    val pin = MutableStateFlow<String>("")
//
//    fun enterPin(value: String) {
//        pin.value = value
//    }
//}