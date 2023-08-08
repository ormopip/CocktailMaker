package com.formacion.cocktailmaker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.formacion.cocktailmaker.navigation.NavigationGraph
import com.formacion.cocktailmaker.presentation.theme.CocktailMakerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CocktailMakerTheme {
               NavigationGraph()
            }
        }
    }
}