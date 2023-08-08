package com.formacion.cocktailmaker.DataBuilders

import com.formacion.cocktailmaker.domain.model.CocktailModel

class CocktailDataBuilder {
    val id= "test-id"
    var name = "cocktail-name"
    var category= "category"
    var alcoholic = "alcoholic"
    var glass = "glass"
    var instructions = "instructions"
    var image= "image"
    var ingredients = mapOf(Pair("test", "cocktail"))

    fun buildSingle() = CocktailModel(
        id = id,
        name = name,
        category = category,
        alcoholic = alcoholic,
        glass = glass,
        instructions = instructions,
        image = image,
        ingredients = ingredients
    )

    fun withName(name: String): CocktailDataBuilder {
        this.name = name
        return this
    }
}