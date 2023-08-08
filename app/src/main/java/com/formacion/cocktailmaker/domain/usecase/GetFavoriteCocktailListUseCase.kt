package com.formacion.cocktailmaker.domain.usecase

import com.formacion.cocktailmaker.data.CocktailRepository
import com.formacion.cocktailmaker.domain.model.CocktailModel
import com.formacion.cocktailmaker.domain.model.IngredientModel
import kotlinx.coroutines.flow.Flow

class GetFavoriteCocktailListUseCase (
    private val cocktailRepository: CocktailRepository
) {
    suspend fun invoke(): Flow<List<CocktailModel>> = cocktailRepository.getFavorites()
}
