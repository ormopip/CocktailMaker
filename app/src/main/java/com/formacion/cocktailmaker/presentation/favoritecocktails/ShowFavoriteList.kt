package com.formacion.cocktailmaker.presentation.favoritecocktails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.formacion.cocktailmaker.domain.model.CocktailModel
import com.formacion.cocktailmaker.presentation.theme.globalPadding

@Composable
fun ShowFavoriteList(
    favoriteList: List<CocktailModel>?
) {
    Text(text = "Favorites",
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(
            top= 8.dp),
    )

    Spacer(modifier = Modifier.height(10.dp))

        val scrollState = rememberLazyListState()
        LazyColumn(
            state = scrollState,
            modifier = Modifier.padding(
                top = 55.dp,
                bottom = 55.dp

            ),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            items(favoriteList?.size ?: 0) { i ->
                val item = favoriteList?.get(i)
                item?.let { favorite ->
                    ShowFavorite(favorite)
                }
            }
        }
    }

