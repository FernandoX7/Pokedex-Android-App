package com.fernando.ramirez.pokedex.data.domain.usecase

import com.fernando.ramirez.pokedex.data.domain.repository.PokemonRepository
import com.fernando.ramirez.pokedex.data.io.db.pokemon.Pokemon

class GetPokemonUseCase(
  private val pokemonRepository: PokemonRepository,
) {

  suspend fun execute(forceUpdate: Boolean): List<Pokemon> {
    return pokemonRepository.getAll(forceUpdate)
  }
}
