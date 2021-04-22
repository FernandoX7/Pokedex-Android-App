package com.fernando.ramirez.pokedex.ui.presentation.di

import com.fernando.ramirez.pokedex.ui.presentation.PokedexViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ViewModelFactoryModule {

  @Singleton
  @Provides
  fun providesPokedexViewModelFactory() = PokedexViewModelFactory()
}
