package com.fernando.ramirez.pokedex.data.repository.pokemon.datasource.implementation

import com.fernando.ramirez.pokedex.data.io.response.PokemonResponse
import com.fernando.ramirez.pokedex.data.io.service.PokedexService
import com.fernando.ramirez.pokedex.data.repository.pokemon.datasource.PokemonRemoteDataSource
import retrofit2.Response

class PokemonRemoteDataSourceImpl(
  private val pokedexService: PokedexService
): PokemonRemoteDataSource {

  override suspend fun getPokemon(): Response<PokemonResponse> {
    return pokedexService.getPokemon()
  }
}
