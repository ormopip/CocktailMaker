package com.formacion.cocktailmaker.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.formacion.cocktailmaker.presentation.cocktailgen.CocktailGeneratorScreen
import com.formacion.cocktailmaker.presentation.ingredientlist.IngredientListScreen
import com.formacion.cocktailmaker.presentation.detail.IngredientDetailScreen
import com.formacion.cocktailmaker.presentation.favoritecocktails.SavedCocktailsScreen

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

fun NavGraphBuilder.addIngredientDetailScreen(navController: NavHostController) {
    composable(
        route = Screen.IngredientDetailScreen.route + "/{ingredientId}",
        arguments = Screen.IngredientDetailScreen.arguments
    ) { navBackStackEntry ->
        val name = navBackStackEntry.arguments?.getString("ingredientId") ?: ""
        IngredientDetailScreen(name = name){
            navController.popBackStack()
        }
    }
}
