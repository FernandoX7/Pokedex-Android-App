package com.fernando.ramirez.pokedex.ui.presentation.di.core

import com.fernando.ramirez.pokedex.data.domain.repository.PokemonRepository
import com.fernando.ramirez.pokedex.data.repository.pokemon.PokemonRepositoryImpl
import com.fernando.ramirez.pokedex.data.repository.pokemon.datasource.PokemonCacheDataSource
import com.fernando.ramirez.pokedex.data.repository.pokemon.datasource.PokemonDbDataSource
import com.fernando.ramirez.pokedex.data.repository.pokemon.datasource.PokemonRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

  @Provides
  @Singleton
  fun providesPokemonRepository(
    pokemonCacheDataSource: PokemonCacheDataSource,
    pokemonDbDataSource: PokemonDbDataSource,
    pokemonRemoteDataSource: PokemonRemoteDataSource,
  ): PokemonRepository {
    return PokemonRepositoryImpl(
      pokemonCacheDataSource,
      pokemonDbDataSource,
      pokemonRemoteDataSource,
    )
  }
}
