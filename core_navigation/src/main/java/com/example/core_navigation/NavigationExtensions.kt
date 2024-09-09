package com.example.core_navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

/**
 * Добавляет [Composable] в [NavGraphBuilder] с параметрами по умолчанию
 */
fun NavGraphBuilder.composable(
    destination: NavigationDestination,
    content: @Composable (NavBackStackEntry) -> Unit,
) {
    val args = mutableListOf<NamedNavArgument>()
    args += destination.arguments
    composable(
        route = destination.route(),
        arguments = args,
        content = content
    )
}
