package com.formacion.cocktailmaker.data

import com.formacion.cocktailmaker.data.mappers.toIngredientModel
import com.formacion.cocktailmaker.data.remote.RemoteDataSource
import com.formacion.cocktailmaker.domain.model.IngredientModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CocktailRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
) : CocktailRepository {
    override suspend fun getIngredientList(): Flow<List<IngredientModel>> {
        return remoteDataSource.getIngredientList().map { list ->
            list.map { ingredient ->
                ingredient.toIngredientModel()
            }
        }
    }
}