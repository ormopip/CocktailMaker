package com.formacion.cocktailmaker.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.formacion.cocktailmaker.domain.model.IngredientModel
import com.formacion.cocktailmaker.domain.usecase.GetIngredientListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class IngredientListViewModel(
    private val getIngredientListUseCase: GetIngredientListUseCase
) : ViewModel() {

    private val _ingredientList = MutableStateFlow<IngredientListState>(IngredientListState.Idle)
    val ingredientList: StateFlow<IngredientListState> get() = _ingredientList

    private val _errorMessage = MutableLiveData<List<IngredientModel>>()
    val errorMessage: LiveData<List<IngredientModel>> get() = _errorMessage

    init {
        getData()
    }

    private fun getData(){
        viewModelScope.launch {
            try {
                withContext(Dispatchers.IO){
                    getIngredientListUseCase.invoke().collect { result->
                        _ingredientList.value = IngredientListState.IngredientList(result)
                    }
                }

            } catch(t:Throwable){

            }
        }
    }



}