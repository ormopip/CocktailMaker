package com.formacion.cocktailmaker.domain.model

data class IngredientInfoModel(
    val id: String,
    val name: String,
    val description: String,
    val type: String,
    val alcohol: String,
    val abv: String,
)