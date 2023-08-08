package com.formacion.cocktailmaker.di

import com.formacion.cocktailmaker.domain.usecase.GetIngredientListUseCase
import com.formacion.cocktailmaker.domain.usecase.GetRandomCocktailUseCase
import org.koin.dsl.module

val domainModule = module {
    single { GetIngredientListUseCase(get()) }
    single { GetRandomCocktailUseCase(get()) }
}
