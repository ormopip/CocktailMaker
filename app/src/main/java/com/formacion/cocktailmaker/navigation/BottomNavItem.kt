package com.formacion.cocktailmaker.navigation

import com.formacion.cocktailmaker.R

sealed class BottomNavItem(var title:String, var icon:Int, var screen_route:String){
    object Home : BottomNavItem("Home", R.drawable.ic_random_cocktail,"home")
    object MyNetwork: BottomNavItem("My Network",R.drawable.ic_ingredient_list,"my_network")
    object AddPost: BottomNavItem("Post",R.drawable.ic_guardados,"add_post")
}