package com.formacion.cocktailmaker.presentation.cocktailgen

import com.formacion.cocktailmaker.domain.model.CocktailModel
import com.formacion.cocktailmaker.domain.model.IngredientModel
import com.formacion.cocktailmaker.presentation.list.IngredientListState

sealed class RandomCocktailState {
    object Idle: RandomCocktailState()
    object Loading: RandomCocktailState()
    data class RandomCocktail(val RandomCocktail: CocktailModel): RandomCocktailState()
}