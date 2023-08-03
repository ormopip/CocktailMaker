package com.formacion.cocktailmaker.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

fun NavGraphBuilder.addLoginScreen(navController: NavController){
    composable(Screen.LoginScreen.route) {
       /* LoginScreen(
            onForgotClicked = {
                navController.navigate(Screen.ForgotPasswordScreen.route)
            },
            onLoginSuccess = {
                navController.navigate(Screen.HeroListScreen.route)
            }
        )*/
    }
}

fun NavGraphBuilder.addHeroListScreen(navController: NavController){

}

fun NavGraphBuilder.addHeroDetailScreen(){

}