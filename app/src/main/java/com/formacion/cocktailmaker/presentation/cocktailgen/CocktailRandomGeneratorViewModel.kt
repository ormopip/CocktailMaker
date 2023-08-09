package com.formacion.cocktailmaker.presentation.cocktailgen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.formacion.cocktailmaker.domain.model.CocktailModel
import com.formacion.cocktailmaker.domain.usecase.DeleteFavoriteCocktailUseCase
import com.formacion.cocktailmaker.domain.usecase.GetFavoriteCocktailListUseCase
import com.formacion.cocktailmaker.domain.usecase.GetRandomCocktailUseCase
import com.formacion.cocktailmaker.domain.usecase.InsertFavoriteCocktailUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CocktailRandomGeneratorViewModel (
    private val getRandomCocktailUseCase: GetRandomCocktailUseCase,
    private val getFavoriteCocktailListUseCase: GetFavoriteCocktailListUseCase,
    private val insertFavoriteCocktailUseCase: InsertFavoriteCocktailUseCase,
    private val deleteFavoriteCocktailUseCase: DeleteFavoriteCocktailUseCase
) : ViewModel() {

    private val _randomCocktail = MutableStateFlow<RandomCocktailState>(RandomCocktailState.Idle)
    val randomCocktail: StateFlow<RandomCocktailState> get() = _randomCocktail

    private val _favoriteCocktail = MutableStateFlow(false)
    val favoriteCocktail: StateFlow<Boolean> get() = _favoriteCocktail

    init {
        getData()
    }

    fun getData() {
        viewModelScope.launch {
            try {
                withContext(Dispatchers.IO) {
                    getRandomCocktailUseCase.invoke().collect { result ->
                        _randomCocktail.value = RandomCocktailState.RandomCocktail(result)
                        getFavoriteCocktailListUseCase.invoke().collect { favorites ->
                            val find = favorites.find {
                                it.name == result.name
                            }
                            if (find != null) _favoriteCocktail.value = true
                        }
                    }
                }

            } catch (t: Throwable) {

            }
        }
    }

    fun insertFavorite(cocktail: CocktailModel) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                insertFavoriteCocktailUseCase.invoke(cocktail)
            }
        }
    }

    fun deleteFavorite(cocktail: CocktailModel) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                deleteFavoriteCocktailUseCase.invoke(cocktail)
            }
        }
    }
}