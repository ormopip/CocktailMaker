package com.formacion.cocktailmaker.presentation.ingredientlist

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.formacion.cocktailmaker.R
import com.formacion.cocktailmaker.domain.model.IngredientModel
import com.formacion.cocktailmaker.presentation.theme.Typography

@Composable
fun ShowList(
    ingredientList: List<IngredientModel>?,
    onItemClick: (String) -> Unit
) {
    val state = rememberLazyGridState()
    Surface(
        color = Color.Black,
        contentColor = contentColorFor(Color.Black)
    ) {
        Row(
            modifier = Modifier.
                        fillMaxWidth()
                .padding(top= 10.dp),
            horizontalArrangement = Arrangement.Center) {

            Image(
                painterResource(R.drawable.ball),
                "content description",
                modifier = Modifier.size(40.dp))

            Text(
                text = "Cocktail ingredients",
                style = Typography.titleLarge,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            )

            Image(
                painterResource(R.drawable.ball),
                "content description",
                modifier = Modifier.size(40.dp))
        }


        Spacer(modifier = Modifier.height(10.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = 55.dp,
                    bottom = 55.dp,
                ),
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
}


