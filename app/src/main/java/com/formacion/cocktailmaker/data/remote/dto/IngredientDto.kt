package com.formacion.cocktailmaker.data.remote.dto

import com.squareup.moshi.Json

data class IngredientDto(
    @Json(name="strIngredient1") val id:String?
)