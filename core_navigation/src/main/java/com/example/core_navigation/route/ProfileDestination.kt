package com.example.core_navigation.route

import com.example.core_navigation.NavigationDestination

object ProfileDestination : NavigationDestination {
    override fun route(): String = PROFILE_SCREEN_ROUTE
    private const val PROFILE_SCREEN_ROUTE = "profile_screen"
}