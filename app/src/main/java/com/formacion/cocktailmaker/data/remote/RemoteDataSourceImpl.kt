package com.formacion.cocktailmaker.data.remote

import com.formacion.cocktailmaker.data.remote.dto.IngredientDto
import com.formacion.cocktailmaker.data.remote.dto.SearchDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RemoteDataSourceImpl (
    private val cocktailApi: CocktailApi
) : RemoteDataSource {
    override suspend fun getIngredientList(): Flow<List<IngredientDto>> = flow {
        emit(cocktailApi.getIngredientList())
    }
}