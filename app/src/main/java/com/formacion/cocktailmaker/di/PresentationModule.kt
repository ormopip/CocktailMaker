package com.formacion.cocktailmaker.di

import com.formacion.cocktailmaker.presentation.cocktailgen.CocktailRandomGeneratorViewModel
import com.formacion.cocktailmaker.presentation.list.IngredientListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { IngredientListViewModel(get()) }
    viewModel { CocktailRandomGeneratorViewModel(get()) }
}