package com.fernando.ramirez.pokedex.data.repository.pokemon.datasource

import com.fernando.ramirez.pokedex.data.io.db.pokemon.Pokemon

interface PokemonDbDataSource {
  suspend fun deleteAll(): Int
  suspend fun getPokemonFromDb(): List<Pokemon>
  suspend fun savePokemonToDb(pokemon: List<Pokemon>)
}
