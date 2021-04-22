package com.fernando.ramirez.pokedex.data.io.response

import com.fernando.ramirez.pokedex.data.io.db.pokemon.Pokemon

data class PokemonResponse(
  val results: List<Pokemon>
)
