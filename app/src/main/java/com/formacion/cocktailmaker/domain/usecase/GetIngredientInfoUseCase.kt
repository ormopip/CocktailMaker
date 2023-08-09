package com.formacion.cocktailmaker.domain.usecase

import com.formacion.cocktailmaker.data.CocktailRepository
import com.formacion.cocktailmaker.domain.model.CocktailModel

class GetIngredientInfoUseCase (
    private val cocktailRepository: CocktailRepository
) {
    suspend fun invoke(name: String) = cocktailRepository.getIngredientInfo(name)
}