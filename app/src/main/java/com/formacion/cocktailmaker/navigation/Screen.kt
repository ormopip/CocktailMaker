package com.formacion.cocktailmaker.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Screen(
    val route: String,
    val arguments: List<NamedNavArgument>
) {
    object IngredientListScreen: Screen(
        route = "ingredientList",
        arguments = emptyList()
    )
}