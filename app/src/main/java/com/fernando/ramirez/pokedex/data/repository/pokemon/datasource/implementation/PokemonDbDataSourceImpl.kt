package com.fernando.ramirez.pokedex.data.repository.pokemon.datasource.implementation

import com.fernando.ramirez.pokedex.data.io.db.pokemon.Pokemon
import com.fernando.ramirez.pokedex.data.io.db.pokemon.PokemonDAO
import com.fernando.ramirez.pokedex.data.repository.pokemon.datasource.PokemonDbDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PokemonDbDataSourceImpl(
  private val pokemonDAO: PokemonDAO,
): PokemonDbDataSource {

  override suspend fun deleteAll(): Int {
    return pokemonDAO.deleteAll()
  }

  override suspend fun getPokemonFromDb(): List<Pokemon> {
    return pokemonDAO.getAll()
  }

  override suspend fun savePokemonToDb(pokemon: List<Pokemon>) {
    CoroutineScope(Dispatchers.IO).launch {
      pokemonDAO.insertPokemon(pokemon)
    }
  }
}
