package com.formacion.cocktailmaker.presentation.ingredientlist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.formacion.cocktailmaker.domain.model.IngredientModel
import com.formacion.cocktailmaker.presentation.common.ShowIngredient
import com.formacion.cocktailmaker.presentation.theme.globalPadding

@Composable
fun ShowList(
    ingredientList: List<IngredientModel>?,
    onItemClick: (String) -> Unit
) {
    val state = rememberLazyGridState()

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        state = state,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        content = {
        items(ingredientList?.size ?: 0) { i ->
            val item = ingredientList?.get(i)
            item?.let { ingredient ->
                ShowIngredient(ingredient) {
                    onItemClick.invoke(ingredient.id)
                }
            }

        }
    })
}