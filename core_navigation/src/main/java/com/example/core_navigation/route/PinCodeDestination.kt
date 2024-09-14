package com.example.core_navigation.route

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.core_navigation.NavigationDestination

object PinCodeDestination : NavigationDestination {
    override fun route(): String = "$PIN_CODE_SCREEN_ROUTE/{$PHONE}/{$CODE}"

    override val arguments: List<NamedNavArgument>
        get() = listOf(
            navArgument(PHONE) { type = NavType.StringType }
        )

    const val PHONE = "phone"
    const val CODE = "code"
    private const val PIN_CODE_SCREEN_ROUTE = "pin_code_screen"

    fun createRoute(code: String, phone: String) =
        "$PIN_CODE_SCREEN_ROUTE/$phone/$code"
}