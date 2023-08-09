package com.formacion.cocktailmaker.DataBuilders

import com.formacion.cocktailmaker.domain.model.IngredientInfoModel

class IngredientInfoDataBuilder {
    val id= "test-id"
    var name = "cocktail-name"
    var description= "description"
    var type = "type"
    var alcohol = "alcohol"
    var abv = "abv"

    fun buildSingle() = IngredientInfoModel(
        id = id,
        name = name,
        description = description,
        type = type,
        alcohol = alcohol,
        abv= abv
    )

    fun withName(name: String): IngredientInfoDataBuilder {
        this.name = name
        return this
    }
}