package com.fernando.ramirez.pokedex.ui.presentation.pokedex

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fernando.ramirez.pokedex.data.io.db.pokemon.Pokemon
import com.fernando.ramirez.pokedex.ui.theme.PokedexTheme

@Composable
fun PokedexCompose(
  viewModel: PokedexViewModel
) {
  PokedexComposeContent(
    modifier = Modifier.fillMaxSize(),
    pokemon = viewModel.pokemon,
    onUpdateClick = viewModel::onUpdateClick,
  )
}

@Composable
fun PokedexComposeContent(
  modifier: Modifier = Modifier,
  pokemon: LiveData<List<Pokemon>>,
  onUpdateClick: () -> Unit,
) {
  Column(
    modifier = modifier
      .background(color = Color.White)
  ) {
    Button(onClick = onUpdateClick) {
      Text(text = "Update")
    }

    PokemonList(pokemon)
  }
}

@Composable
fun PokemonList(pokemon: LiveData<List<Pokemon>>) {
  val pokemonAsState by pokemon.observeAsState(initial = emptyList())

  LazyColumn(
    contentPadding = PaddingValues(
      horizontal = 16.dp,
      vertical = 8.dp
    ),
    modifier = Modifier
      .background(color = Color.LightGray)
      .fillMaxWidth()
  ) {
    items(pokemonAsState) {
      PokemonRowItem(it.name)
    }
  }
}

@Composable
fun PokemonRowItem(pokemonName: String) {
  Row(
    Modifier.padding(0.dp, 60.dp)
  ) {
    Text(pokemonName)
  }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
  val viewModel = viewModel(PokedexViewModel::class.java)

  PokedexTheme {
    PokedexComposeContent(
      modifier = Modifier.fillMaxSize(),
      pokemon = viewModel.pokemon,
      onUpdateClick = viewModel::onUpdateClick,
    )
  }
}
