package com.fernando.ramirez.pokedex.ui.presentation.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.fernando.ramirez.pokedex.ui.presentation.di.pokedex.PokedexViewModelFactory
import com.fernando.ramirez.pokedex.ui.theme.PokedexTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PokedexActivity : ComponentActivity() {

  @Inject
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
