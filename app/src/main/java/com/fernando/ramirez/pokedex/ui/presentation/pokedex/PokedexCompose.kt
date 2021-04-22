package com.fernando.ramirez.pokedex.ui.presentation.pokedex

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fernando.ramirez.pokedex.data.io.db.pokemon.Pokemon
import com.fernando.ramirez.pokedex.ui.theme.PokedexTheme
import com.google.accompanist.coil.rememberCoilPainter
import com.google.accompanist.imageloading.ImageLoadState
import java.util.Locale

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
      .fillMaxWidth()
  ) {
    items(pokemonAsState) {
      PokemonRowItem(it)
    }
  }
}

@Composable
fun PokemonRowItem(pokemon: Pokemon) {
  Card(
    modifier = Modifier
      .background(Color.Gray)
      .fillMaxWidth()
      .height(200.dp),
  ) {
    val imageUrl = "https://pokeres.bastionbot.org/images/pokemon/${pokemon.id}.png"
    val painter = rememberCoilPainter(imageUrl)

    Row(
      modifier = Modifier
        .size(150.dp),
      horizontalArrangement = Arrangement.SpaceBetween,
      verticalAlignment = Alignment.CenterVertically
    ) {
      Box(
        Modifier
          .size(100.dp),
        contentAlignment = Alignment.Center,
      ) {
        Text(
          modifier = Modifier
            .align(Alignment.CenterStart)
            .padding(8.dp, 0.dp, 0.dp, 0.dp),
          text = pokemon.name.capitalize(Locale.getDefault()),
          style = MaterialTheme.typography.subtitle1,
          fontWeight = FontWeight.SemiBold,
        )
      }
      Box(
        Modifier
          .size(200.dp),
        contentAlignment = Alignment.Center,
      ) {
        Box {
          Image(
            painter = painter,
            contentScale = ContentScale.Fit,
            contentDescription = "${pokemon.name} thumbnail",
          )

          when (painter.loadState) {
            ImageLoadState.Loading -> {
              CircularProgressIndicator(Modifier.align(Alignment.Center))
            }
            is ImageLoadState.Error -> {
            }
            ImageLoadState.Empty -> {
            }
            is ImageLoadState.Success -> {
            }
          }
        }
      }
    }
  }

  Spacer(modifier = Modifier.height(16.dp))
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
