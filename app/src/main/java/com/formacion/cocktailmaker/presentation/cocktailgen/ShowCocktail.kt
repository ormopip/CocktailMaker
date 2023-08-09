package com.formacion.cocktailmaker.presentation.cocktailgen

import android.annotation.SuppressLint
import android.widget.TextView
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidViewBinding
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.bumptech.glide.Glide
import com.formacion.cocktailmaker.R
import com.formacion.cocktailmaker.databinding.RandomCocktailLayoutBinding
import com.formacion.cocktailmaker.domain.model.CocktailModel
import com.formacion.cocktailmaker.presentation.common.ShowCocktailIngredient
import com.formacion.cocktailmaker.presentation.theme.globalPadding
import org.koin.androidx.compose.koinViewModel

@SuppressLint("SuspiciousIndentation")
@Composable
fun ShowCocktail(
    cocktail: CocktailModel,
    viewModel: CocktailRandomGeneratorViewModel = koinViewModel()
) {
    val favorite = viewModel.favoriteCocktail.collectAsStateWithLifecycle()

    AndroidViewBinding(RandomCocktailLayoutBinding::inflate) {
        Glide.with(this.root)
            .load(cocktail.image)
            .placeholder(R.drawable.ball)
            .error(R.drawable.ball)
            .into(this.cocktailImage)
        cocktailName.text = cocktail.name
        description.text = cocktail.instructions
        category.text = cocktail.category

        addFavoriteButton.setOnClickListener {
            viewModel.insertFavorite(cocktail)
            viewModel.getData()
        }

        skipCocktailButton.setOnClickListener {
            viewModel.getData()
        }

        ingredientsList.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                Column(
                    modifier = Modifier.padding(
                        bottom= 55.dp
                    )
                ) {
                    cocktail.ingredients.forEach {
                        ShowCocktailIngredient(it.key, it.value)
                    }
                    }
                }
            }
        }
    }



@Composable
@Preview
fun ShowCocktailPreview() {
}

