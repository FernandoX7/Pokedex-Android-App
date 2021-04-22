package com.fernando.ramirez.pokedex.data.io.db

import android.content.Context
import androidx.room.Room
import com.fernando.ramirez.pokedex.data.io.db.pokemon.PokemonDAO
import com.fernando.ramirez.pokedex.data.io.db.pokemon.PokemonDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RoomDatabaseModule {

  @Provides
  fun providesPokemonDatabase(
    @ApplicationContext context: Context
  ): PokemonDatabase = Room.databaseBuilder(
    context,
    PokemonDatabase::class.java,
    PokemonDatabase.databaseName
  ).build()

  @Provides
  fun providesPokemonDAO(db: PokemonDatabase): PokemonDAO {
    return db.pokemonDAO
  }
}
