package com.formacion.cocktailmaker.presentation.savedcocktails

import com.formacion.cocktailmaker.domain.model.CocktailModel

sealed class SavedCocktailsState {
    object Idle: SavedCocktailsState()
    object Loading: SavedCocktailsState()
    data class FavoriteList(val favoriteList: List<CocktailModel>): SavedCocktailsState()
}