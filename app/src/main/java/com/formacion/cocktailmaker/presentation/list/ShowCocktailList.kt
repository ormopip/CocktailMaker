package com.formacion.cocktailmaker.presentation.list

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.formacion.cocktailmaker.domain.model.IngredientModel
import com.formacion.cocktailmaker.presentation.common.ShowIngredient
import com.formacion.cocktailmaker.presentation.theme.globalPadding

@Composable
fun ShowList(
    ingredientList: List<IngredientModel>?,
    onItemClick: (String) -> Unit
) {
    LazyColumn(
        modifier = Modifier.padding(
            vertical = globalPadding
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(ingredientList?.size ?: 0) { i ->
            val item = ingredientList?.get(i)
            item?.let { ingredient ->
                ShowIngredient(ingredient) {
                    onItemClick.invoke(ingredient.id)
                }
            }
        }
    }
}