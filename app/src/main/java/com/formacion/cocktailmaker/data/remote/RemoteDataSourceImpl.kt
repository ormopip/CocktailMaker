package com.formacion.cocktailmaker.data.remote

import com.formacion.cocktailmaker.data.remote.dto.IngredientArrayDto
import com.formacion.cocktailmaker.data.remote.dto.IngredientInfoArrayDto
import com.formacion.cocktailmaker.data.remote.dto.RandomCocktailArrayDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RemoteDataSourceImpl (
    private val cocktailApi: CocktailApi
) : RemoteDataSource {
    override suspend fun getIngredientList(): Flow<IngredientArrayDto> = flow {
        emit(cocktailApi.getIngredientList("list"))
    }

    override suspend fun getRandomCocktail(): Flow<RandomCocktailArrayDto> = flow {
        emit(cocktailApi.getRandomCocktail())
    }

    override suspend fun getIngredientInfo(name: String): Flow<IngredientInfoArrayDto> = flow {
        emit(cocktailApi.getIngredientDetail(name))
    }
}