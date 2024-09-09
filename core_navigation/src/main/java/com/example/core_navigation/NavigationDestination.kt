package com.example.core_navigation

import androidx.navigation.NamedNavArgument

/**
 * Функциональный интерфейс, описывающий общие параметры
 * для пункта назначения
 */
interface NavigationDestination {

    /** Строка, по которой происходит навигация к экрану */
    fun route(): String

    /** Аргументы, которые необходимо передать */
    val arguments: List<NamedNavArgument>
        get() = emptyList()

}
