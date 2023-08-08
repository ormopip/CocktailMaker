package com.formacion.cocktailmaker.presentation.cocktailgen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.formacion.cocktailmaker.DataBuilders.CocktailDataBuilder
import com.formacion.cocktailmaker.R
import com.formacion.cocktailmaker.domain.model.CocktailModel
import com.formacion.cocktailmaker.presentation.common.ShowCocktailIngredient
import com.formacion.cocktailmaker.presentation.common.ShowIngredient
import com.formacion.cocktailmaker.presentation.theme.globalPadding

@Composable
fun ShowCocktail(
    cocktail: CocktailModel,
) {
        Column(
            modifier = Modifier
                .padding(globalPadding
                ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            AsyncImage(
                modifier = Modifier
                    .size(300.dp)
                    .clip(CircleShape),
                placeholder = painterResource(id = R.drawable.ball),
                error = painterResource(id = R.drawable.ball),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(cocktail.image)
                    .build(), contentDescription = "",

                )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                color = Color.Black,
                fontSize = 24.sp,
                style = MaterialTheme.typography.h4,
                text = cocktail.name
            )

            Text(
                text = cocktail.category,
                fontSize = 18.sp,
                modifier = Modifier.padding(3.dp)
            )

            Text(
                text = cocktail.alcoholic,
                modifier = Modifier.padding(3.dp),
                style = MaterialTheme.typography.subtitle1
            )

            Text(
                text = cocktail.instructions,
                modifier = Modifier.padding(3.dp),
                style = MaterialTheme.typography.subtitle1,
                textAlign = TextAlign.Center
            )

            LazyColumn(
                modifier = Modifier.padding(
                    vertical = globalPadding
                ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(cocktail.ingredients.size ?: 0) { i ->
                    val measures = cocktail.ingredients.values.toList()
                    val ingredients = cocktail.ingredients.keys.toList()
                    cocktail.ingredients.let {
                        ShowCocktailIngredient(ingredients.get(i), measures.get(i))
                    }
                }
            }
        }

    }


@Composable
@Preview
fun ShowCocktailPreview() {
    ShowCocktail(
        CocktailDataBuilder().buildSingle()
    )
}

