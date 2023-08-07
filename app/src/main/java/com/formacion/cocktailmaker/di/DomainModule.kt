package com.formacion.cocktailmaker.di

import com.formacion.cocktailmaker.domain.usecase.GetIngredientListUseCase
import org.koin.dsl.module

val domainModule = module {
    single { GetIngredientListUseCase(get()) }
}
