package com.fernando.ramirez.pokedex.ui.presentation.pokedex

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fernando.ramirez.pokedex.data.domain.usecase.GetPokemonUseCase
import com.fernando.ramirez.pokedex.data.io.db.pokemon.Pokemon
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PokedexViewModel(
  private val getPokemonUseCase: GetPokemonUseCase,
) : ViewModel() {

  private val _pokemon = MutableLiveData<List<Pokemon>>()
  val pokemon: LiveData<List<Pokemon>>
    get() = _pokemon

  private val _statusMessage = MutableLiveData<String>()
  val statusMessage: LiveData<String>
    get() = _statusMessage

  init {
    getPokemon(false)
  }

  private fun getPokemon(foceUpdate: Boolean) {
    viewModelScope.launch(Dispatchers.IO) {
      setGetPokemonResult(
        getPokemonUseCase.execute(foceUpdate)
      )
    }
  }

  fun onUpdateClick() {
    setStatusMessage("Refreshing")
    getPokemon(true)
  }

  private fun setGetPokemonResult(pokemon: List<Pokemon>) {
    viewModelScope.launch(Dispatchers.Main) {
      _pokemon.value = pokemon
    }
  }

  private fun setStatusMessage(message: String) {
    viewModelScope.launch(Dispatchers.Main) {
      _statusMessage.value = message
    }
  }
}
