package com.formacion.cocktailmaker.presentation.favoritecocktails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> get() = _errorMessage

    init {
        getData()
    }

    private fun getData(){
        viewModelScope.launch {
            try {
                _errorMessage.value = null
                withContext(Dispatchers.IO){
                    getFavoriteCocktailListUseCase.invoke().collect { result->
                        _favoriteList.value = SavedCocktailsState.FavoriteList(result)
                    }
                }

            } catch(t:Throwable){
                _errorMessage.value = "Error"
            }
        }
    }



}