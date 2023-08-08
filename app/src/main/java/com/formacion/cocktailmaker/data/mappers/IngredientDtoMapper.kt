package com.formacion.cocktailmaker.data.mappers

import com.formacion.cocktailmaker.data.local.model.CocktailLocal
import com.formacion.cocktailmaker.data.remote.dto.IngredientDto
import com.formacion.cocktailmaker.data.remote.dto.RandomCocktailDto
import com.formacion.cocktailmaker.domain.model.CocktailModel
import com.formacion.cocktailmaker.domain.model.IngredientModel

fun IngredientDto.toIngredientModel() = IngredientModel(
    id = id ?: "",
)

fun RandomCocktailDto.toCocktailModel(): CocktailModel {
    val ingredients= mapOf(Pair(ingredient1, measure1),
        Pair(ingredient2, measure2),
        Pair(ingredient3, measure3),
        Pair(ingredient4, measure4),
        Pair(ingredient5, measure5),
        Pair(ingredient6, measure6),
        Pair(ingredient7, measure7),
        Pair(ingredient8, measure8))

    return CocktailModel(
        id= id?: "",
        name= name?: "",
        category= category?: "",
        glass= glass?: "",
        instructions = instructions?: "",
        image = photoUrl?: "",
        ingredients = ingredients.filterValues {  it != null } as Map<String, String>,
        alcoholic= alcoholic?: "",
        )
}

fun CocktailLocal.toCocktailModel() = CocktailModel(
    id, name, category, alcoholic, glass, instructions, image, ingredients
)

fun CocktailModel.toCocktailLocal() = CocktailLocal(
    id, name, category, alcoholic, glass, instructions, image, ingredients, favorite = true
)
