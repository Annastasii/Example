package com.example.core_navigation.route

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.core_navigation.NavigationDestination

object ChatDestination : NavigationDestination {

    override fun route(): String = "$CHAT_SCREEN_ROUTE/{$ID}"

    override val arguments: List<NamedNavArgument>
        get() = listOf(
            navArgument(ID) { type = NavType.IntType }
        )

    const val ID = "id"
    private const val CHAT_SCREEN_ROUTE = "chat_screen"

    fun createRoute(id: Int) =
        "$CHAT_SCREEN_ROUTE/$id"
}