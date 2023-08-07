package com.formacion.cocktailmaker.presentation.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.formacion.cocktailmaker.R
import com.formacion.cocktailmaker.domain.model.IngredientModel
import com.formacion.cocktailmaker.presentation.theme.globalElevation
import com.formacion.cocktailmaker.presentation.theme.globalPadding
import com.formacion.cocktailmaker.presentation.theme.globalRoundedCornerShape

@Composable
fun ShowIngredient(
    ingredient: IngredientModel,
    onClick: (() -> Unit)? = null
) {
    var starred by remember {
        mutableStateOf(false)
    }

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
                    .data(ingredient.photoUrl)
                    .build(), contentDescription = ""
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
                        text = ingredient.name,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = ingredient.description,
                        maxLines = 4,
                        overflow = TextOverflow.Ellipsis
                    )
                }

             /*   // Star
                AndroidView(
                    modifier = Modifier.clickable {
                        val newState = !starred
                        starred = newState
                    },
                    factory = { context ->
                        StarComponent(context).apply {
                            this.checked = starred
                        }
                    },
                    update = {
                        it.checked = starred
                    }
                )*/

            }
        }
    }
}


@Composable
@Preview
fun ShowIngredientPreview() {
    ShowIngredient(
        IngredientModel("dsfdf", "sdfsdf" , "sdfsdf", "sdfsdf")
    ) {
        // Nothing todo here
    }
}

