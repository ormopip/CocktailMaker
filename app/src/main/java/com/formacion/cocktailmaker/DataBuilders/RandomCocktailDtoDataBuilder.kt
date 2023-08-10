package com.formacion.cocktailmaker.DataBuilders

import com.formacion.cocktailmaker.data.remote.dto.RandomCocktailDto

class RandomCocktailDtoDataBuilder {
    val id = "test-cocktail-dto"
    var name = "cocktail-dto"
    val category = "category"
    val alcoholic = "alcoholic"
    val glass = "glass"
    val instructions = "instructions"
    val photoUrl = "photo-url"
    val ingredient1 = "ingredient1"
    val ingredient2 = "ingredient2"
    val ingredient3 = "ingredient3"
    val ingredient4 = "ingredient4"
    val ingredient5 = "ingredient5"
    val ingredient6 = "ingredient6"
    val ingredient7 = "ingredient7"
    val ingredient8 = "ingredient8"
    val measure1 = "measure1"
    val measure2 = "measure2"
    val measure3 = "measure3"
    val measure4 = "measure4"
    val measure5 = "measure5"
    val measure6 = "measure6"
    val measure7 = "measure7"
    val measure8 = "measure8"

    fun buildSingle() = RandomCocktailDto(
        id = id,
        name = name,
        category = category,
        alcoholic = alcoholic,
        glass = glass,
        instructions = instructions,
        photoUrl = photoUrl,
        ingredient1 = ingredient1,
        ingredient2 = ingredient2,
        ingredient3 = ingredient3,
        ingredient4 = ingredient4,
        ingredient5 = ingredient5,
        ingredient6 = ingredient6,
        ingredient7 = ingredient7,
        ingredient8 = ingredient8,
        measure1 = measure1,
        measure2 = measure2,
        measure3 = measure3,
        measure4 = measure4,
        measure5 = measure5,
        measure6 = measure6,
        measure7 = measure7,
        measure8 = measure8,
    )

    fun withName(name: String?): RandomCocktailDtoDataBuilder {
        this.name = name?:""
        return this
    }

}