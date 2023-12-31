package com.formacion.cocktailmaker.presentation.ingredientlist

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.formacion.cocktailmaker.components.ShowError
import org.koin.androidx.compose.koinViewModel

@Composable
fun IngredientListScreen(
    ingredientListViewModel: IngredientListViewModel = koinViewModel(),
    onItemClick: (String) -> Unit
) {
    val state = ingredientListViewModel.ingredientList.collectAsStateWithLifecycle()

    val errorState = ingredientListViewModel.errorMessage.observeAsState()

    if (errorState.value?.isNotEmpty() == true) {
        val error = errorState.value
        ShowError(error = error?: "")
    }

    when(state.value) {
        is IngredientListState.IngredientList -> {
            ShowList(
                ingredientList = (state.value as IngredientListState.IngredientList).ingredientList,
                onItemClick = onItemClick
            )
        }
        is IngredientListState.Idle -> {}
        is IngredientListState.Loading -> {}
    }
}

@Preview
@Composable
fun HeroListScreenPreview() {
    IngredientListScreen {
        // Empty callback
    }
}