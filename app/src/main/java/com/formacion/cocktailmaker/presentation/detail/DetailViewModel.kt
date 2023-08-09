package com.formacion.cocktailmaker.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.formacion.cocktailmaker.domain.model.IngredientModel
import com.formacion.cocktailmaker.domain.usecase.GetIngredientInfoUseCase
import com.formacion.cocktailmaker.domain.usecase.GetIngredientListUseCase
import com.formacion.cocktailmaker.presentation.ingredientlist.IngredientListState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailViewModel(
    private val getIngredientInfoUseCase: GetIngredientInfoUseCase
) : ViewModel() {

    private val _ingredientInfo = MutableStateFlow<IngredientInfoState>(IngredientInfoState.Idle)
    val ingredientInfo: StateFlow<IngredientInfoState> get() = _ingredientInfo

    fun getData(name: String){
        viewModelScope.launch {
            try {
                withContext(Dispatchers.IO){
                    getIngredientInfoUseCase.invoke(name).collect { result->
                        _ingredientInfo.value = IngredientInfoState.IngredientInfo(result)
                    }
                }

            } catch(t:Throwable){

            }
        }
    }



}