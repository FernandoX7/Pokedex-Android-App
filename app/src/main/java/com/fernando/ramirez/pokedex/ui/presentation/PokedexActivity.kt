package com.fernando.ramirez.pokedex.ui.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.fernando.ramirez.pokedex.ui.theme.PokedexTheme

class PokedexActivity : ComponentActivity() {

  lateinit var viewModelFactory: PokedexViewModelFactory
  lateinit var viewModel: PokedexViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    viewModel = ViewModelProvider(
      this,
      viewModelFactory
    ).get(PokedexViewModel::class.java)

    setContent {
      PokedexTheme {
        PokedexCompose()
      }
    }
  }
}
