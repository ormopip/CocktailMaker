package com.formacion.cocktailmaker.presentation.savedcocktails

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.formacion.cocktailmaker.domain.model.CocktailModel
import com.formacion.cocktailmaker.presentation.theme.globalPadding

@Composable
fun ShowFavoriteList(
    favoriteList: List<CocktailModel>?
) {
    LazyColumn(
        modifier = Modifier.padding(
            vertical = globalPadding
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(favoriteList?.size ?: 0) { i ->
            val item = favoriteList?.get(i)
            item?.let { favorite ->
                ShowFavorite(favorite)
            }
        }
    }
}