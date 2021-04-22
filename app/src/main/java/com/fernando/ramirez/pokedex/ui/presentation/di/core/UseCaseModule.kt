package com.fernando.ramirez.pokedex.ui.presentation.di.core

import com.fernando.ramirez.pokedex.data.domain.repository.PokemonRepository
import com.fernando.ramirez.pokedex.data.domain.usecase.GetPokemonUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

  @Provides
  @Singleton
  fun providesGetPokemonUseCase(
    pokemonRepository: PokemonRepository,
  ): GetPokemonUseCase = GetPokemonUseCase(pokemonRepository)
}
