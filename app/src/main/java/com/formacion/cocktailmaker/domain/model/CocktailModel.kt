package com.formacion.cocktailmaker.domain.model

data class CocktailModel(
    val id: String,
    val name: String,
    val category: String,
    val alcoholic: String,
    val glass: String,
    val instructions: String,
    val image: String,
    val ingredients: Map<String, String>,
)