package com.formacion.cocktailmaker.presentation.cocktailgen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.formacion.cocktailmaker.components.ShowError
import org.koin.androidx.compose.koinViewModel

@Composable
fun CocktailGeneratorScreen(
    viewModel: CocktailRandomGeneratorViewModel = koinViewModel()
) {
    val state = viewModel.randomCocktail.collectAsStateWithLifecycle()

    val errorState = viewModel.errorMessage.observeAsState()

    if (errorState.value?.isNotEmpty() == true) {
        val error = errorState.value
        ShowError(error = error?: "")
    }

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