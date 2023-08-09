package com.formacion.cocktailmaker.di

import com.formacion.cocktailmaker.presentation.cocktailgen.CocktailRandomGeneratorViewModel
import com.formacion.cocktailmaker.presentation.detail.DetailViewModel
import com.formacion.cocktailmaker.presentation.ingredientlist.IngredientListViewModel
import com.formacion.cocktailmaker.presentation.favoritecocktails.SavedCocktailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { IngredientListViewModel(get()) }
    viewModel { CocktailRandomGeneratorViewModel(get(), get(), get(), get()) }
    viewModel { SavedCocktailsViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}