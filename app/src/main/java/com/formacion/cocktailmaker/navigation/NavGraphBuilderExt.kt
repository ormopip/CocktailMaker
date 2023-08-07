package com.formacion.cocktailmaker.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.formacion.cocktailmaker.presentation.list.IngredientListScreen
import com.formacion.cocktailmaker.presentation.detail.IngredientDetailScreen

fun NavGraphBuilder.addIngredientListScreen(navController: NavController) {
    composable(Screen.IngredientListScreen.route) {
        IngredientListScreen { ingredientId ->
            navController.navigate("${Screen.IngredientDetailScreen.route}/$ingredientId")
        }
    }
}

fun NavGraphBuilder.addIngredientDetailScreen() {
    composable(Screen.IngredientDetailScreen.route) {
        IngredientDetailScreen()
    }
}
