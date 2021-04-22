package com.fernando.ramirez.pokedex.ui.presentation.di.core

import com.fernando.ramirez.pokedex.data.repository.pokemon.datasource.PokemonCacheDataSource
import com.fernando.ramirez.pokedex.data.repository.pokemon.datasource.implementation.PokemonCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CacheDataModule {

  @Singleton
  @Provides
  fun providesPokemonCacheDataSource(): PokemonCacheDataSource {
    return PokemonCacheDataSourceImpl()
  }
}
