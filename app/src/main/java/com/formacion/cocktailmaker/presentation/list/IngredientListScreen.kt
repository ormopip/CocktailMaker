package com.formacion.cocktailmaker.presentation.list

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.formacion.cocktailmaker.presentation.theme.globalPadding
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