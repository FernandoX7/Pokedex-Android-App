package com.fernando.ramirez.pokedex.data.io

import com.fernando.ramirez.pokedex.data.io.service.PokedexService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

  @Provides
  fun providesPokedexService(retrofit: Retrofit): PokedexService {
    return retrofit.create(PokedexService::class.java)
  }
}
