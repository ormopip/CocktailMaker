package com.formacion.cocktailmaker.DataBuilders

import com.formacion.cocktailmaker.data.remote.dto.IngredientInfoDto
import com.squareup.moshi.Json

class IngredientInfoDtoDataBuilder {
    val id: String? = "test-id"
    var name: String? = "test-name"
    var strDescription = "strDescription"
    var strType = "strType"
    var strAlcohol = "strAlcohol"
    var strABV = "strABV"

    fun buildSingle() = IngredientInfoDto(
        id = id,
        name = name,
        description = strDescription,
        type = strType,
        alcohol = strAlcohol,
        abv = strABV
    )

    fun withName(name: String?): IngredientInfoDtoDataBuilder {
        this.name = name
        return this
    }

}