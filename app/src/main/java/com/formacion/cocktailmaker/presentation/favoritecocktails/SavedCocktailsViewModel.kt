package com.formacion.cocktailmaker.presentation.favoritecocktails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.formacion.cocktailmaker.domain.usecase.GetFavoriteCocktailListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SavedCocktailsViewModel(
    private val getFavoriteCocktailListUseCase: GetFavoriteCocktailListUseCase,
) : ViewModel() {

    private val _favoriteList = MutableStateFlow<SavedCocktailsState>(SavedCocktailsState.Idle)
    val favoriteList: StateFlow<SavedCocktailsState> get() = _favoriteList

    init {
        getData()
    }

    private fun getData(){
        viewModelScope.launch {
            try {
                withContext(Dispatchers.IO){
                    getFavoriteCocktailListUseCase.invoke().collect { result->
                        _favoriteList.value = SavedCocktailsState.FavoriteList(result)
                    }
                }

            } catch(t:Throwable){

            }
        }
    }



}