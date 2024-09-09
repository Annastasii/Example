package com.example.core_navigation.route

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.core_navigation.NavigationDestination

object PinCodeDestination : NavigationDestination {
    override fun route(): String = "$PIN_CODE_SCREEN_ROUTE/{$PHONE}"

    override val arguments: List<NamedNavArgument>
        get() = listOf(
            navArgument(PHONE) { type = NavType.StringType }
        )

    const val PHONE = "email"
    private const val PIN_CODE_SCREEN_ROUTE = "defect_details_screen"

    fun createRoute(phone: String) =
        "$PIN_CODE_SCREEN_ROUTE/$phone"
}