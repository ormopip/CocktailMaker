package com.formacion.cocktailmaker.presentation.cocktailgen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> get() = _errorMessage

    init {
        getData()
    }

    fun getData() {
        viewModelScope.launch {
            try {
                _errorMessage.value = null
                withContext(Dispatchers.IO) {
                    getRandomCocktailUseCase.invoke().collect { result ->
                        _randomCocktail.value = RandomCocktailState.RandomCocktail(result)
                        getFavoriteCocktailListUseCase.invoke().collect { favoritesList ->
                            val found = favoritesList.find { favorite ->
                                (favorite.name.equals(result.name))
                            }
                            _favoriteCocktail.value = found!= null
                        }
                    }
                }

            } catch (t: Throwable) {
                _errorMessage.value = "Error"
            }
        }
    }

    fun checkFavorite(cocktail: CocktailModel) {
        viewModelScope.launch {
            try {
                getFavoriteCocktailListUseCase.invoke().collect { favoritesList ->
                    favoritesList.map { favorite ->
                           if(favorite.name.equals(cocktail.name)) _favoriteCocktail.value = true
                        }
                    }
                } catch (t: Throwable) {
                _errorMessage.value = "Error"
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