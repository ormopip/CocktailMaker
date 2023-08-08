package com.formacion.cocktailmaker.domain.usecase

import com.formacion.cocktailmaker.data.CocktailRepository
import com.formacion.cocktailmaker.domain.model.CocktailModel
import kotlinx.coroutines.flow.Flow

class InsertFavoriteCocktailUseCase (
    private val cocktailRepository: CocktailRepository
) {
    suspend fun invoke(cocktail: CocktailModel) = cocktailRepository.insertFavorite(cocktail)
}