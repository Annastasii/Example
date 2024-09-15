package com.example.feature_auth.ui.register.model


data class ScreenState(
   val showMessage: Boolean = false,
   val incorrectName: Boolean = false,
   val userId: Int? = null
)