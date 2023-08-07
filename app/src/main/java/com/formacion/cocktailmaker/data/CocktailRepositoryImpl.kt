package com.formacion.cocktailmaker.data

import com.formacion.cocktailmaker.data.mappers.toIngredientModel
import com.formacion.cocktailmaker.data.remote.RemoteDataSource
import com.formacion.cocktailmaker.data.remote.dto.IngredientDto
import com.formacion.cocktailmaker.domain.model.IngredientModel
import com.formacion.cocktailmaker.navigation.Screen
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CocktailRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
) : CocktailRepository {
    override suspend fun getIngredientList(): Flow<List<IngredientModel>> {
        return remoteDataSource.getIngredientList().map {
            it?.ingredients?.map { ingredient ->
                ingredient.toIngredientModel()
            } ?: listOf(IngredientModel("sdfsdf"))
        }
    }
}

