package com.formacion.cocktailmaker.presentation.detail

import com.formacion.cocktailmaker.domain.model.IngredientInfoModel

sealed class IngredientInfoState {
    object Idle: IngredientInfoState()
    object Loading: IngredientInfoState()
    data class IngredientInfo(val ingredientInfo:IngredientInfoModel): IngredientInfoState()
}