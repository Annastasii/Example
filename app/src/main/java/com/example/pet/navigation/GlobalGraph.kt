package com.example.pet.navigation

import android.content.Context
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.example.core_navigation.composable
import com.example.core_navigation.route.AuthDestination
import com.example.core_navigation.route.PinCodeDestination
import com.example.feature_auth.ui.auth.AuthScreen
import com.example.feature_auth.ui.pin_code.PinCodeScreen

/** Глобальный навигационный граф */
fun NavGraphBuilder.globalGraph(
    context: Context,
    navController: NavController,
) {

    composable(
        destination = AuthDestination
    ) { AuthScreen(navController) }

    composable(
        destination = PinCodeDestination
    ) { PinCodeScreen(navController) }

}
