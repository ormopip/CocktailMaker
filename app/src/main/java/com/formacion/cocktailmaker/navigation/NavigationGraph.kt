package com.formacion.cocktailmaker.navigation

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun NavigationGraph() {
    val navController = rememberNavController()
    Scaffold(bottomBar = { BottomNavigation(navController = navController)}
    ) {
        NavHost(
            navController = navController,
            startDestination = BottomNavItem.IngredientList.screen_route,
        ) {
            addIngredientListScreen(navController)
            addIngredientDetailScreen(navController)
            addRandomCocktailScreen()
            addSavedCocktailsScreen()
        }
    }
    

}