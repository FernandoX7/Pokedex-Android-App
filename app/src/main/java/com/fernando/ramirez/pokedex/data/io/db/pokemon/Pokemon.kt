package com.fernando.ramirez.pokedex.data.io.db.pokemon

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = Pokemon.tableName)
data class Pokemon(

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = primaryKeyIdColumnName)
  val id: Int,

  @ColumnInfo(name = nameColumnName)
  val name: String,

  @ColumnInfo(name = urlColumnName)
  val url: String,
) {
  companion object {
    const val tableName = "pokemon_table"

    const val primaryKeyIdColumnName = "pokemon_primary_key_id"
    const val nameColumnName = "pokemon_name"
    const val urlColumnName = "pokemon_url"
  }
}
