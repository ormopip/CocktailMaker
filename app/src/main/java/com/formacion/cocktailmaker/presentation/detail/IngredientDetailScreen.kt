package com.formacion.cocktailmaker.presentation.detail

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.formacion.cocktailmaker.presentation.theme.globalPadding

@Composable
fun IngredientsDetailScreen(
    onItemClick: (String) -> Unit
) {
    LazyColumn(
        modifier = Modifier.padding(
            vertical = globalPadding
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
    }
}