package com.formacion.cocktailmaker.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.formacion.cocktailmaker.presentation.cocktailgen.CocktailGeneratorScreen
import com.formacion.cocktailmaker.presentation.list.IngredientListScreen
import com.formacion.cocktailmaker.presentation.detail.IngredientDetailScreen
import com.formacion.cocktailmaker.presentation.savedcocktails.SavedCocktailsScreen

fun NavGraphBuilder.addIngredientListScreen(navController: NavController) {
    composable(BottomNavItem.IngredientList.screen_route) {
        IngredientListScreen { ingredientId ->
            navController.navigate("${Screen.IngredientDetailScreen.route}/$ingredientId")
        }
    }
}

fun NavGraphBuilder.addRandomCocktailScreen() {
    composable(BottomNavItem.RandomCocktail.screen_route) {
        CocktailGeneratorScreen()
    }
}

fun NavGraphBuilder.addSavedCocktailsScreen() {
    composable(BottomNavItem.SavedCocktails.screen_route) {
        SavedCocktailsScreen()
    }
}

fun NavGraphBuilder.addIngredientDetailScreen() {
    composable(Screen.IngredientDetailScreen.route) {
        IngredientDetailScreen()
    }
}
