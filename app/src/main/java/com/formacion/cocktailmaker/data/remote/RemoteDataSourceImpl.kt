package com.formacion.cocktailmaker.data.remote

import com.formacion.cocktailmaker.data.remote.dto.IngredientArrayDto
import com.formacion.cocktailmaker.data.remote.dto.IngredientDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RemoteDataSourceImpl (
    private val cocktailApi: CocktailApi
) : RemoteDataSource {
    override suspend fun getIngredientList(): Flow<IngredientArrayDto> = flow {
       // emit(cocktailApi.getIngredientList(SearchDto()))
        emit(cocktailApi.getIngredientList("list"))
    }
}