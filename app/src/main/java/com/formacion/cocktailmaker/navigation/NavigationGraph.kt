package com.formacion.cocktailmaker.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController


@Composable
fun NavigationGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.IngredientListScreen.route,
    ) {
        addIngredientListScreen(navController)
        addIngredientDetailScreen()
    }
}