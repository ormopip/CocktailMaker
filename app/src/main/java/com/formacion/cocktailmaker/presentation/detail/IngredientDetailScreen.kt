package com.formacion.cocktailmaker.presentation.detail

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.formacion.cocktailmaker.presentation.favoritecocktails.SavedCocktailsState
import com.formacion.cocktailmaker.presentation.favoritecocktails.ShowFavoriteList
import org.koin.androidx.compose.koinViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun IngredientDetailScreen(
   name: String,
   viewModel: DetailViewModel = koinViewModel(),
   onBack: () -> Unit
) {
   viewModel.getData(name)
   val detailState = viewModel.ingredientInfo.collectAsStateWithLifecycle()

   Scaffold(
      topBar = {
      TopAppBar (
         title = {
            Text("Detalle de ${name}")
         },
         navigationIcon = {
            IconButton(
               modifier = Modifier.semantics {
                  contentDescription = "Ir al listado de ingredientes"
               },
               onClick = onBack
            ) {
               Icon(Icons.Filled.ArrowBack, null)
            }
         }
      )
   }
   ) {
      when(detailState.value) {
         is IngredientInfoState.IngredientInfo -> {
            ShowIngredientInfo(
               ingredient = (detailState.value as IngredientInfoState.IngredientInfo).ingredientInfo,
            )
         }
         is IngredientInfoState.Idle -> {}
         is IngredientInfoState.Loading -> {}
      }
   }

}

@Composable
fun ShowLoading() {
   // TODO ShowLoading
}
