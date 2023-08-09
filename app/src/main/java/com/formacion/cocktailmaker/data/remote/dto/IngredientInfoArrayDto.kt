package com.formacion.cocktailmaker.data.remote.dto

import com.squareup.moshi.Json

data class IngredientInfoArrayDto (
    @Json(name="ingredients") val ingredients:List<IngredientInfoDto>?
)