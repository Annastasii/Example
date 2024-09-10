package com.example.core_navigation.route

import com.example.core_navigation.NavigationDestination

object RegisterDestination : NavigationDestination {
    override fun route(): String = REGISTER_SCREEN_ROUTE
    private const val REGISTER_SCREEN_ROUTE = "register_screen"
}