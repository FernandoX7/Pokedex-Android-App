package com.fernando.ramirez.pokedex.data.io.db.pokemon

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PokemonDAO {
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insertPokemon(pokemon: List<Pokemon>)

  @Query("SELECT * FROM ${Pokemon.tableName}")
  suspend fun getAll(): List<Pokemon>

  @Query("DELETE FROM ${Pokemon.tableName}")
  suspend fun deleteAll(): Int
}
