package com.formacion.cocktailmaker.presentation.favoritecocktails

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.formacion.cocktailmaker.components.ShowError
import org.koin.androidx.compose.koinViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SavedCocktailsScreen(
    viewModel: SavedCocktailsViewModel = koinViewModel()
) {
    val state = viewModel.favoriteList.collectAsStateWithLifecycle()

    val errorState = viewModel.errorMessage.observeAsState()

    if (errorState.value?.isNotEmpty() == true) {
        val error = errorState.value
        ShowError(error = error?: "")
    }

    when(state.value) {
        is SavedCocktailsState.FavoriteList -> {
            Scaffold {
                ShowFavoriteList(
                    favoriteList = (state.value as SavedCocktailsState.FavoriteList).favoriteList,
                )
            }
        }
        is SavedCocktailsState.Idle -> {}
        is SavedCocktailsState.Loading -> {}
    }
}

@Preview
@Composable
fun HeroListScreenPreview() {
}
