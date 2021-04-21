package com.fernando.ramirez.pokedex.ui.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.fernando.ramirez.pokedex.ui.theme.PokedexTheme

class PokedexActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      PokedexTheme {
        PokedexCompose()
      }
    }
  }
}
