package com.formacion.cocktailmaker.data.mappers

import com.formacion.cocktailmaker.data.remote.dto.IngredientDto
import com.formacion.cocktailmaker.domain.model.IngredientModel

fun IngredientDto.toIngredientModel() = IngredientModel(
    id = id ?: "",
)