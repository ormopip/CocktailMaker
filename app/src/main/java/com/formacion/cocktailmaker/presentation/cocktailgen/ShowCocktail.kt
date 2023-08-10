package com.formacion.cocktailmaker.presentation.cocktailgen

import android.annotation.SuppressLint
import android.view.View
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
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
import org.koin.androidx.compose.koinViewModel


@SuppressLint("SuspiciousIndentation")
@Composable
fun ShowCocktail(
    cocktail: CocktailModel,
    viewModel: CocktailRandomGeneratorViewModel = koinViewModel()
) {

    val state = viewModel.favoriteCocktail.collectAsStateWithLifecycle()
    viewModel.checkFavorite(cocktail)

    AndroidViewBinding(RandomCocktailLayoutBinding::inflate) {

        if(state.value){
            addFavoriteButtonEmpty.visibility = View.GONE
            addFavoriteButtonFilled.visibility = View.VISIBLE
        } else {
            addFavoriteButtonFilled.visibility = View.GONE
            addFavoriteButtonEmpty.visibility = View.VISIBLE
        }

        Glide.with(this.root)
            .load(cocktail.image)
            .placeholder(R.drawable.ball)
            .error(R.drawable.ball)
            .into(this.cocktailImage)
        cocktailName.text = cocktail.name
        description.text = cocktail.instructions
        category.text = cocktail.category


        addFavoriteButtonEmpty.setOnClickListener {
            viewModel.insertFavorite(cocktail)
            viewModel.checkFavorite(cocktail)
            addFavoriteButtonEmpty.visibility = View.GONE
            addFavoriteButtonFilled.visibility = View.VISIBLE
        }


        skipCocktailButton.setOnClickListener {
            viewModel.getData()
            addFavoriteButtonEmpty.visibility = View.VISIBLE
            addFavoriteButtonFilled.visibility = View.GONE
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

fun checkFavoriteState(){

}

@Composable
@Preview
fun ShowCocktailPreview() {
}

