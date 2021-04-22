package com.fernando.ramirez.pokedex.ui.presentation.di

import com.fernando.ramirez.pokedex.data.io.service.PokedexService
import com.fernando.ramirez.pokedex.data.repository.pokemon.datasource.PokemonRemoteDataSource
import com.fernando.ramirez.pokedex.data.repository.pokemon.datasource.implementation.PokemonRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataModule {

  @Provides
  @Singleton
  fun providesPokemonRemoteDataSource(
    pokedexService: PokedexService
  ): PokemonRemoteDataSource {
    return PokemonRemoteDataSourceImpl(pokedexService)
  }
}
