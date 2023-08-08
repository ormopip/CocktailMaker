package com.formacion.cocktailmaker.presentation.cocktailgen

import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.koinViewModel

@Composable
fun CocktailGeneratorScreen(
    cocktailRandomGeneratorViewModel: CocktailRandomGeneratorViewModel = koinViewModel()
) {
    val state = cocktailRandomGeneratorViewModel.randomCocktail.collectAsStateWithLifecycle()

    when(state.value) {
        is RandomCocktailState.RandomCocktail -> {
            ShowCocktail(
                cocktail = (state.value as RandomCocktailState.RandomCocktail).RandomCocktail,
            )
        }
        is RandomCocktailState.Idle -> {}
        is RandomCocktailState.Loading -> {}
    }
}