package com.formacion.cocktailmaker.presentation.savedcocktails

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.koinViewModel

@Composable
fun SavedCocktailsScreen(
    viewModel: SavedCocktailsViewModel = koinViewModel()
) {
    val state = viewModel.favoriteList.collectAsStateWithLifecycle()

    when(state.value) {
        is SavedCocktailsState.FavoriteList -> {
            ShowFavoriteList(
                favoriteList = (state.value as SavedCocktailsState.FavoriteList).favoriteList,
            )
        }
        is SavedCocktailsState.Idle -> {}
        is SavedCocktailsState.Loading -> {}
    }
}

@Preview
@Composable
fun HeroListScreenPreview() {
}
