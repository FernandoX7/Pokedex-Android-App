package com.fernando.ramirez.pokedex.ui.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class PokedexViewModelFactory() : ViewModelProvider.Factory {

  override fun <T : ViewModel?> create(modelClass: Class<T>): T {
    if (modelClass.isAssignableFrom(PokedexViewModel::class.java)) {
      return PokedexViewModel() as T
    }
    throw IllegalArgumentException("Unknown View Model")
  }
}
