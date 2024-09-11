package com.example.core_navigation.route

import com.example.core_navigation.NavigationDestination

object DialogListDestination : NavigationDestination {
    override fun route(): String = DIALOG_LIST_SCREEN_ROUTE
    private const val DIALOG_LIST_SCREEN_ROUTE = "dialog_list_screen"
}