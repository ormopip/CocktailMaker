package com.formacion.cocktailmaker.presentation.detail

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.formacion.cocktailmaker.presentation.theme.globalPadding
import org.koin.androidx.compose.koinViewModel

@Composable
fun IngredientDetailScreen(
   name: String,
   viewModel: DetailViewModel = koinViewModel()
) {
   viewModel.getData(name)
   val detailState = viewModel.ingredientInfo.collectAsStateWithLifecycle()

   when(detailState.value) {
      is IngredientInfoState.Idle -> {}
      is IngredientInfoState.Loading -> {
         // Composable de Loading
         ShowLoading()
      }
      is IngredientInfoState.IngredientInfo -> {
         ShowIngredientInfo(
            ingredient = (detailState.value as IngredientInfoState.IngredientInfo).ingredientInfo
            // hero = heroState.value.hero
         )
      }
   }

}

@Composable
fun ShowLoading() {
   // TODO ShowLoading
}
