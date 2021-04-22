package com.fernando.ramirez.pokedex.data.repository.pokemon.datasource

import com.fernando.ramirez.pokedex.data.io.db.pokemon.Pokemon

interface PokemonCacheDataSource {
  suspend fun getPokemonFromCache(): List<Pokemon>
  suspend fun savePokemonToCache(pokemon: List<Pokemon>)
}
