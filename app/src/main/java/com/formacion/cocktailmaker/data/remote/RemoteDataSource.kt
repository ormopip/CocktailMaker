package com.formacion.cocktailmaker.data.remote

import com.formacion.cocktailmaker.data.remote.dto.IngredientArrayDto
import com.formacion.cocktailmaker.data.remote.dto.IngredientDto
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    suspend fun getIngredientList(): Flow<IngredientArrayDto?>
}