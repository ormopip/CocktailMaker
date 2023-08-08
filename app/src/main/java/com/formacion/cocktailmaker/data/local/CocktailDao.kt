package com.formacion.cocktailmaker.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.OnConflictStrategy

import com.formacion.cocktailmaker.data.local.model.CocktailLocal

@Dao
interface CocktailDao {
    @Query("SELECT * FROM CocktailTable")
    suspend fun getFavorites(): List<CocktailLocal>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(cocktail: CocktailLocal)

    @Delete
    suspend fun delete(model: CocktailLocal)
}