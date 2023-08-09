package com.formacion.cocktailmaker.data.remote

import com.formacion.cocktailmaker.data.remote.dto.IngredientArrayDto
import com.formacion.cocktailmaker.data.remote.dto.IngredientInfoArrayDto
import com.formacion.cocktailmaker.data.remote.dto.RandomCocktailArrayDto
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    suspend fun getIngredientList(): Flow<IngredientArrayDto?>
    suspend fun getRandomCocktail(): Flow<RandomCocktailArrayDto?>
    suspend fun getIngredientInfo(name: String): Flow<IngredientInfoArrayDto?>
}