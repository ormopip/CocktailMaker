package com.formacion.cocktailmaker.presentation.cocktailgen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.formacion.cocktailmaker.domain.model.IngredientModel
import com.formacion.cocktailmaker.domain.usecase.GetIngredientListUseCase
import com.formacion.cocktailmaker.domain.usecase.GetRandomCocktailUseCase
import com.formacion.cocktailmaker.presentation.list.IngredientListState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.random.Random

class CocktailRandomGeneratorViewModel (
    private val getRandomCocktailUseCase: GetRandomCocktailUseCase
) : ViewModel() {

    private val _randomCocktail = MutableStateFlow<RandomCocktailState>(RandomCocktailState.Idle)
    val randomCocktail: StateFlow<RandomCocktailState> get() = _randomCocktail

    init {
        getData()
    }

    private fun getData(){
        viewModelScope.launch {
            try {
                withContext(Dispatchers.IO){
                    getRandomCocktailUseCase.invoke().collect { result->
                        _randomCocktail.value = RandomCocktailState.RandomCocktail(result)
                    }
                }

            } catch(t:Throwable){

            }
        }
    }

}