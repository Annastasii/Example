package com.example.core_navigation.route

import com.example.core_navigation.NavigationDestination

object MessageListDestination : NavigationDestination {
    override fun route(): String = MESSAGE_LIST_SCREEN_ROUTE
    private const val MESSAGE_LIST_SCREEN_ROUTE = "message_list_screen"
}