package com.formacion.cocktailmaker.di

import com.formacion.cocktailmaker.domain.usecase.DeleteFavoriteCocktailUseCase
import com.formacion.cocktailmaker.domain.usecase.GetFavoriteCocktailListUseCase
import com.formacion.cocktailmaker.domain.usecase.GetIngredientListUseCase
import com.formacion.cocktailmaker.domain.usecase.GetRandomCocktailUseCase
import com.formacion.cocktailmaker.domain.usecase.InsertFavoriteCocktailUseCase
import org.koin.dsl.module

val domainModule = module {
    single { GetIngredientListUseCase(get()) }
    single { GetRandomCocktailUseCase(get()) }
    single { GetFavoriteCocktailListUseCase(get()) }
    single { DeleteFavoriteCocktailUseCase(get()) }
    single { InsertFavoriteCocktailUseCase(get()) }
}
