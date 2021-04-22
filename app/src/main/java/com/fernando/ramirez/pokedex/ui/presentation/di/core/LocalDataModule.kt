package com.fernando.ramirez.pokedex.ui.presentation.di.core

import com.fernando.ramirez.pokedex.data.io.db.pokemon.PokemonDAO
import com.fernando.ramirez.pokedex.data.repository.pokemon.datasource.PokemonDbDataSource
import com.fernando.ramirez.pokedex.data.repository.pokemon.datasource.implementation.PokemonDbDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDataModule {

  @Singleton
  @Provides
  fun providesPokemonDbDataSource(
    pokemonDAO: PokemonDAO
  ): PokemonDbDataSource = PokemonDbDataSourceImpl(pokemonDAO)
}
