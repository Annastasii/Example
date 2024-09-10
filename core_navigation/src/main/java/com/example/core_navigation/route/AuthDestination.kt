package com.example.core_navigation.route

import com.example.core_navigation.NavigationDestination

object AuthDestination : NavigationDestination {
    override fun route(): String = AUTH_SCREEN_ROUTE
    private const val AUTH_SCREEN_ROUTE = "auth_screen"
}