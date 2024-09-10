package com.example.core_navigation.route

import com.example.core_navigation.NavigationDestination

object DialogDestination : NavigationDestination {
    override fun route(): String = DIALOG_SCREEN_ROUTE
    private const val DIALOG_SCREEN_ROUTE = "dialog_screen"
}