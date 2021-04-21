package com.fernando.ramirez.pokedex.ui.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.fernando.ramirez.pokedex.ui.theme.PokedexTheme

@Composable
fun PokedexCompose() {
  PokedexComposeContent(
    modifier = Modifier.fillMaxSize(),
  )
}

@Composable
fun PokedexComposeContent(
  modifier: Modifier = Modifier,
) {
  Column(
    modifier = modifier
      .background(color = Color.White)
  ) {
    Text(text = "Pokedex Home")
  }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
  PokedexTheme {
    PokedexComposeContent(
      modifier = Modifier.fillMaxSize()
    )
  }
}
