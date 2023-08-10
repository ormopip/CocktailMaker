package com.formacion.cocktailmaker.DataBuilders

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.formacion.cocktailmaker.data.local.model.CocktailLocal

class CocktailLocalDataBuilder {
    val id = "test-id"
    var name = "name"
    val category = "category"
    val alcoholic = "alcoholic"
    val glass = "glass"
    val instructions = "instructions"
    val image ="image"
    val ingredients = listOf("one ingredient")
    val measurements = listOf("one measurement")
    val favorite = false

    fun withName(name: String): CocktailLocalDataBuilder {
        this.name = name
        return this
    }

    fun buildSingle() = CocktailLocal(
        id = id,
        name = name,
        category = category,
        alcoholic = alcoholic,
        glass = glass,
        instructions = instructions,
        image = image,
        ingredients = ingredients,
        measurements = measurements,
        favorite = false
    )

}