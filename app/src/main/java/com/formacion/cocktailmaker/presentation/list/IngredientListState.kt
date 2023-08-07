package com.formacion.cocktailmaker.presentation.list

import com.formacion.cocktailmaker.domain.model.IngredientModel

//investigar por qué es una sealed class
sealed class IngredientListState {
    object Idle: IngredientListState()
    object Loading: IngredientListState()
    data class IngredientList(val ingredientList: List<IngredientModel>): IngredientListState()
}