package com.fernando.ramirez.pokedex.data.domain.repository

import com.fernando.ramirez.pokedex.data.io.db.pokemon.Pokemon

interface PokemonRepository {
  suspend fun deleteAll(): Int
  suspend fun getAll(forceUpdate: Boolean): List<Pokemon>
  suspend fun updateAll(): List<Pokemon>
}
