package com.fernando.ramirez.pokedex.data.repository.pokemon

import com.fernando.ramirez.pokedex.data.domain.repository.PokemonRepository
import com.fernando.ramirez.pokedex.data.io.db.pokemon.Pokemon
import com.fernando.ramirez.pokedex.data.repository.pokemon.datasource.PokemonCacheDataSource
import com.fernando.ramirez.pokedex.data.repository.pokemon.datasource.PokemonDbDataSource
import com.fernando.ramirez.pokedex.data.repository.pokemon.datasource.PokemonRemoteDataSource
import timber.log.Timber

class PokemonRepositoryImpl(
  private val pokemonCacheDataSource: PokemonCacheDataSource,
  private val pokemonDbDataSource: PokemonDbDataSource,
  private val pokemonRemoteDataSource: PokemonRemoteDataSource,
) : PokemonRepository {

  override suspend fun deleteAll(): Int {
    return pokemonDbDataSource.deleteAll()
  }

  override suspend fun getAll(forceUpdate: Boolean): List<Pokemon> {
    if (forceUpdate) {
      return getPokemonFromApi()
    }
    return getPokemonFromCache()
  }

  override suspend fun updateAll(): List<Pokemon> {
    val newListOfPokemon = getPokemonFromApi()

    pokemonDbDataSource.deleteAll()

    pokemonDbDataSource.savePokemonToDb(newListOfPokemon)
    pokemonCacheDataSource.savePokemonToCache(newListOfPokemon)

    return newListOfPokemon
  }

  private suspend fun getPokemonFromCache(): List<Pokemon> {
    var pokemonList: List<Pokemon> = listOf()

    try {
      pokemonList = pokemonCacheDataSource.getPokemonFromCache()
    } catch (e: Exception) {
      Timber.e(e)
    }

    if (pokemonList.isNotEmpty()) {
      return pokemonList
    } else {
      pokemonList = getPokemonFromDb()
      pokemonCacheDataSource.savePokemonToCache(pokemonList)
    }
    return pokemonList
  }

  private suspend fun getPokemonFromDb(): List<Pokemon> {
    var pokemonList: List<Pokemon> = listOf()

    try {
      pokemonList = pokemonDbDataSource.getPokemonFromDb()
    } catch (e: Exception) {
      Timber.e(e)
    }

    if (pokemonList.isNotEmpty()) {
      return pokemonList
    } else {
      pokemonList = getPokemonFromApi()
      pokemonDbDataSource.savePokemonToDb(pokemonList)
    }

    return pokemonList
  }

  private suspend fun getPokemonFromApi(): List<Pokemon> {
    var pokemonList: List<Pokemon> = listOf()

    try {
      val response = pokemonRemoteDataSource.getPokemon()
      val body = response.body()
      if (body != null) {
        pokemonList = body.results
      }
    } catch (e: Exception) {
      Timber.e(e)
    }

    return pokemonList
  }
}
