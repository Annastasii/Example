package com.example.core_navigation.route

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.core_navigation.NavigationDestination

object RegisterDestination : NavigationDestination {

    override fun route(): String = "$REGISTER_SCREEN_ROUTE/{$PHONE}"

    override val arguments: List<NamedNavArgument>
        get() = listOf(
            navArgument(PHONE) { type = NavType.StringType }
        )

    const val PHONE = "phone"
    private const val REGISTER_SCREEN_ROUTE = "register_screen"

    fun createRoute(phone: String) =
        "$REGISTER_SCREEN_ROUTE/$phone"
}