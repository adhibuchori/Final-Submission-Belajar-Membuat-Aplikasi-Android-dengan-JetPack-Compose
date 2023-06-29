package com.adhibuchori.demonslayercharacter.ui.screen

sealed class Screen(val route: String) {
    object Home : Screen("home")

    object About : Screen("about")

    object Favourite : Screen("favourite")

    object Detail : Screen("home/{id}") {
        fun createRoute(id: Long) = "home/$id"
    }
}