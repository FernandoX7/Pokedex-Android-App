package com.fernando.ramirez.pokedex.ui.presentation.di.pokedex

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fernando.ramirez.pokedex.data.domain.usecase.GetPokemonUseCase
import com.fernando.ramirez.pokedex.ui.presentation.pokedex.PokedexViewModel

class PokedexViewModelFactory(
  private val getPokemonUseCase: GetPokemonUseCase,
) : ViewModelProvider.Factory {

  override fun <T : ViewModel?> create(modelClass: Class<T>): T {
    if (modelClass.isAssignableFrom(PokedexViewModel::class.java)) {
      return PokedexViewModel(
        getPokemonUseCase
      ) as T
    }
    throw IllegalArgumentException("Unknown View Model")
  }
}
