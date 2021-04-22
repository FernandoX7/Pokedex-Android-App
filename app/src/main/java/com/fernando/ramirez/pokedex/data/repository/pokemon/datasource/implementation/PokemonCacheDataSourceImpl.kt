package com.fernando.ramirez.pokedex.data.repository.pokemon.datasource.implementation

import com.fernando.ramirez.pokedex.data.io.db.pokemon.Pokemon
import com.fernando.ramirez.pokedex.data.repository.pokemon.datasource.PokemonCacheDataSource

class PokemonCacheDataSourceImpl: PokemonCacheDataSource {

  private var pokemonList: List<Pokemon> = listOf()

  override suspend fun getPokemonFromCache(): List<Pokemon> {
    return pokemonList
  }

  override suspend fun savePokemonToCache(pokemon: List<Pokemon>) {
    pokemonList = listOf()
    pokemonList = pokemon
  }
}
