package com.formacion.cocktailmaker.domain.usecase

import com.formacion.cocktailmaker.data.CocktailRepository
import com.formacion.cocktailmaker.domain.model.CocktailModel

class DeleteFavoriteCocktailUseCase (
    private val cocktailRepository: CocktailRepository
) {
    suspend fun invoke(cocktail: CocktailModel) = cocktailRepository.deleteFavorite(cocktail)
}