package com.formacion.cocktailmaker.data.remote.dto

import com.squareup.moshi.Json

data class IngredientInfoDto(
    @Json(name="idIngredient") val id:String?,
    @Json(name="strIngredient") val name:String?,
    @Json(name="strDescription") val description:String?,
    @Json(name="strType") val type:String?,
    @Json(name="strAlcohol") val alcohol:String?,
    @Json(name="strABV") val abv:String?
)