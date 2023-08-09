package com.formacion.cocktailmaker.presentation.detail

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
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
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.formacion.cocktailmaker.R
import com.formacion.cocktailmaker.domain.model.IngredientInfoModel
import com.formacion.cocktailmaker.presentation.cocktailgen.CocktailRandomGeneratorViewModel
import com.formacion.cocktailmaker.presentation.theme.globalPadding
import org.koin.androidx.compose.koinViewModel

@SuppressLint("SuspiciousIndentation")
@Composable
fun ShowIngredientInfo(
    ingredient: IngredientInfoModel,
    viewModel: CocktailRandomGeneratorViewModel = koinViewModel()
) {
    val favorite = viewModel.favoriteCocktail.collectAsStateWithLifecycle()

    val checked = rememberSaveable() { mutableStateOf(favorite.value) }

    Column(
        modifier = Modifier
            .padding(
                globalPadding
            )
            .verticalScroll(rememberScrollState())
        ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(10.dp))
        AsyncImage(
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape),
            placeholder = painterResource(id = R.drawable.ball),
            error = painterResource(id = R.drawable.ball),
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://www.thecocktaildb.com/images/ingredients/${ingredient.name}-Small.png")
                .build(),
            contentDescription = "",
            )
        Spacer(modifier = Modifier.height(10.dp))
        Column() {
            Text(
                color = Color.Black,
                fontSize = 24.sp,
                style = MaterialTheme.typography.h4,
                text = ingredient.name
            )
        }

        Text(
            text = ingredient.description,
            fontSize = 18.sp,
            modifier = Modifier.padding(3.dp)
        )

        Text(
            text = ingredient.alcohol,
            modifier = Modifier.padding(3.dp),
            style = MaterialTheme.typography.subtitle1
        )

        Text(
            text = ingredient.type,
            modifier = Modifier.padding(3.dp),
            style = MaterialTheme.typography.subtitle1,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
@Preview
fun ShowCocktailPreview() {
}

