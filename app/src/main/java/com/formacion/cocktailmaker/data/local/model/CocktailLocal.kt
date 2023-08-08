package com.formacion.cocktailmaker.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CocktailTable")
data class CocktailLocal(
    @PrimaryKey @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "category") val category: String,
    @ColumnInfo(name = "alcoholic") val alcoholic: String,
    @ColumnInfo(name = "glass") val glass: String,
    @ColumnInfo(name = "instructions") val instructions: String,
    @ColumnInfo(name = "image") val image: String,
    @ColumnInfo(name = "ingredients") val ingredients: Map<String, String>,
    @ColumnInfo(name = "favorite") val favorite: Boolean
)