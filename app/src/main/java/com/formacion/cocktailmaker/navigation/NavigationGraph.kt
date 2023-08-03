package com.formacion.cocktailmaker.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController


@Composable
fun NavigationGraph() {
    val navController = rememberNavController()

    //por qué algunos tienen navController y otros no
    NavHost(
        navController = navController,
        startDestination = Screen.LoginScreen.route,
    ) {
        addLoginScreen(navController)
        addHeroListScreen(navController)
        addHeroDetailScreen()
    }
}