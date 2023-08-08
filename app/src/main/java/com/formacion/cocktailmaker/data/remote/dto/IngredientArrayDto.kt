package com.formacion.cocktailmaker.data.remote.dto

import com.squareup.moshi.Json

data class IngredientArrayDto (
    @Json(name="drinks") val ingredients:List<IngredientDto>?
    )
