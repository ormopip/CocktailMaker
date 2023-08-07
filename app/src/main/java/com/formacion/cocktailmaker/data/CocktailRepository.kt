package com.formacion.cocktailmaker.data

import com.formacion.cocktailmaker.domain.model.IngredientModel
import kotlinx.coroutines.flow.Flow

interface CocktailRepository {
    suspend fun getIngredientList(): Flow<List<IngredientModel>>
}