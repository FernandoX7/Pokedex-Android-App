package com.fernando.ramirez.pokedex.data.io.service

import com.fernando.ramirez.pokedex.data.io.response.PokemonResponse
import retrofit2.Response
import retrofit2.http.GET

interface PokedexService {
  @GET("/api/v2/pokemon")
  suspend fun getPokemon(): Response<PokemonResponse>
}
