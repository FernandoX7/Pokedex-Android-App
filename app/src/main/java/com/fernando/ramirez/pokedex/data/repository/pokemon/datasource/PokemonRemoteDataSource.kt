package com.fernando.ramirez.pokedex.data.repository.pokemon.datasource

import com.fernando.ramirez.pokedex.data.io.response.PokemonResponse
import retrofit2.Response

interface PokemonRemoteDataSource {
  suspend fun getPokemon(): Response<PokemonResponse>
}
