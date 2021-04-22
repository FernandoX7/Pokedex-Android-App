package com.fernando.ramirez.pokedex.ui.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fernando.ramirez.pokedex.data.domain.usecase.GetPokemonUseCase

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
