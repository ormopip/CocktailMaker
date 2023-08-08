package com.formacion.cocktailmaker.data

import com.formacion.cocktailmaker.domain.model.CocktailModel
import com.formacion.cocktailmaker.domain.model.IngredientModel
import kotlinx.coroutines.flow.Flow

interface CocktailRepository {
    suspend fun getIngredientList(): Flow<List<IngredientModel>>
    suspend fun getRandomCocktail(): Flow<CocktailModel>
    suspend fun getFavorites(): Flow<List<CocktailModel>>
    suspend fun insertFavorite(cocktailModel: CocktailModel)
    suspend fun deleteFavorite(cocktailModel: CocktailModel)
}