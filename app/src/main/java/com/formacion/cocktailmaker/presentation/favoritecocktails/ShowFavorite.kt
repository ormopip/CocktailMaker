package com.formacion.cocktailmaker.presentation.favoritecocktails

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.formacion.cocktailmaker.R
import com.formacion.cocktailmaker.components.AlcoholComponent
import com.formacion.cocktailmaker.domain.model.CocktailModel
import com.formacion.cocktailmaker.presentation.theme.globalElevation
import com.formacion.cocktailmaker.presentation.theme.globalPadding
import com.formacion.cocktailmaker.presentation.theme.globalRoundedCornerShape

@Composable
fun ShowFavorite(
    favorite: CocktailModel,
    onClick: (() -> Unit)? = null
) {

    Card(
        modifier = Modifier.padding(globalPadding),
        elevation = CardDefaults.cardElevation(
            defaultElevation = globalElevation
        ),
        shape = RoundedCornerShape(globalRoundedCornerShape)
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .clickable {
                    onClick?.invoke()
                },
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape),
                placeholder = painterResource(id = R.drawable.ball),
                error = painterResource(id = R.drawable.ball),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(favorite.image)
                    .build(), contentDescription = "${favorite.name} image"
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = favorite.name,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.semantics {
                            this.contentDescription = "${favorite.name}"
                        }
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    AndroidView(
                        factory = { context ->
                            AlcoholComponent(context).apply {
                                this.state = alcoholicType(favorite.alcoholic)
                            }
                        }
                    , modifier = Modifier.semantics {
                            this.contentDescription = "${favorite.alcoholic} icon"
                        }
                    )
                }
            }
        }
    }
}

fun alcoholicType(type: String): AlcoholComponent.AlcoholType{
    return when(type){
        "Alcoholic" -> AlcoholComponent.AlcoholType.Alcoholic
        "Non alcoholic" -> AlcoholComponent.AlcoholType.NonAlcoholic
        "Optional alcohol" -> AlcoholComponent.AlcoholType.OptionalAlcohol
        else -> { AlcoholComponent.AlcoholType.OptionalAlcohol}
    }
}

@Composable
@Preview
fun ShowIngredientPreview() {

}

