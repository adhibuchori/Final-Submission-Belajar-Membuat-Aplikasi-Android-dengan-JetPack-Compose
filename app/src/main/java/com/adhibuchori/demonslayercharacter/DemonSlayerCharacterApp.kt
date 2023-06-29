package com.adhibuchori.demonslayercharacter

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.adhibuchori.demonslayercharacter.ui.screen.Screen
import com.adhibuchori.demonslayercharacter.ui.screen.about.AboutScreen
import com.adhibuchori.demonslayercharacter.ui.screen.detail.DetailScreen
import com.adhibuchori.demonslayercharacter.ui.screen.favourite.FavouriteScreen
import com.adhibuchori.demonslayercharacter.ui.screen.home.HomeScreen
import com.adhibuchori.demonslayercharacter.ui.theme.DemonSlayerCharacterTheme

@Composable
fun DemonSlayerCharacterApp(
    navController: NavHostController = rememberNavController(),
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    navBackStackEntry?.destination?.route
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = Modifier
    ) {
        composable(Screen.Home.route) {
            HomeScreen(
                navigateToAbout = { navController.navigate(Screen.About.route) },
                navigateToDetail = { id -> navController.navigate(Screen.Detail.createRoute(id)) },
                navigateToFavorite = { navController.navigate(Screen.Favourite.route) },
            )
        }
        composable(Screen.About.route) {
            AboutScreen()
        }
        composable(Screen.Favourite.route) {
            FavouriteScreen(navigateToDetail = { id ->
                navController.navigate(
                    Screen.Detail.createRoute(
                        id
                    )
                )
            })
        }
        composable(
            route = Screen.Detail.route,
            arguments = listOf(navArgument("id") { type = NavType.LongType })
        ) {
            val id = it.arguments?.getLong("id") ?: -1L
            DetailScreen(id = id, navigateBack = { navController.navigateUp() })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DemonSlayerCharacterAppPreview() {
    DemonSlayerCharacterTheme {
        DemonSlayerCharacterApp()
    }
}