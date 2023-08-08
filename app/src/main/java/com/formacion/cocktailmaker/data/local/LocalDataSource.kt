package com.formacion.cocktailmaker.data.local

import com.formacion.cocktailmaker.data.local.model.CocktailLocal
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    suspend fun insertCocktail(cocktail: CocktailLocal)
    suspend fun getFavorites(): Flow<List<CocktailLocal>>
    suspend fun deleteFavorite(cocktail: CocktailLocal)
}