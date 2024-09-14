package com.example.feature_auth.ui.auth.model

data class ScreenState(
    val flags: Flags = Flags.RUSSIA,
    val isSuccess: Boolean = false,
    val isRegister: Boolean = false,
    val isProgress: Boolean = false,
    val navScreen: NavScreen = NavScreen.MAIN,
)