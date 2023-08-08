package com.formacion.cocktailmaker.navigation

import com.formacion.cocktailmaker.R

sealed class BottomNavItem(var title:String, var icon:Int, var screen_route:String){
    object RandomCocktail : BottomNavItem("RandomCocktail", R.drawable.ic_random_cocktail,"random_cocktail")
    object IngredientList: BottomNavItem("IngredientList",R.drawable.ic_ingredient_list,"ingredient_list")
    object SavedCocktails: BottomNavItem("SavedCocktails",R.drawable.ic_guardados,"saved_cocktails")
}