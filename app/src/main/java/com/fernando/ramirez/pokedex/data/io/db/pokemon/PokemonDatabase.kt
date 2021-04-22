package com.fernando.ramirez.pokedex.data.io.db.pokemon

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Pokemon::class], version = 1)
abstract class PokemonDatabase : RoomDatabase() {
  abstract val pokemonDAO: PokemonDAO

  companion object {
    const val databaseName = "pokemon_database"
  }
}
