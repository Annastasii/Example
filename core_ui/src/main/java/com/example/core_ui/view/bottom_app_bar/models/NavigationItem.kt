package com.example.core_ui.view.bottom_app_bar.models

import com.example.core_navigation.route.DialogListDestination
import com.example.core_navigation.route.ProfileDestination
import com.example.core_ui.R

/** Элементы навигации нижнего меню приложения */
sealed class NavigationItem(val route: String, val icon: Int, val title: Int) {

    object Message : NavigationItem(
        DialogListDestination.route(), R.drawable.ic_dialog, R.string.message
    )

    object Profile : NavigationItem(
        ProfileDestination.route(), R.drawable.ic_profile, R.string.profile
    )
}
