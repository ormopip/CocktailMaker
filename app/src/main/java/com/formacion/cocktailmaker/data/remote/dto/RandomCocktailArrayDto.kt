package com.formacion.cocktailmaker.data.remote.dto

import com.squareup.moshi.Json

data class RandomCocktailArrayDto (
    @Json(name="drinks") val cocktailList:List<RandomCocktailDto>?
)
