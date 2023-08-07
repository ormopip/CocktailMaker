package com.formacion.cocktailmaker.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.formacion.cocktailmaker.presentation.list.IngredientListScreen

fun NavGraphBuilder.addIngredientListScreen(navController: NavController){
    composable(Screen.IngredientListScreen.route) {
        IngredientListScreen {
        }
    }
}
