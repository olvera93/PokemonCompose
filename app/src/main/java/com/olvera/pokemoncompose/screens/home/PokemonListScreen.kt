package com.olvera.pokemoncompose.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import kotlin.time.Duration.Companion.hours

@Composable
fun PokemonListScreen(viewModel: PokemonListViewModel) {

    val pokemons by viewModel.pokemonList.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getPokemonList()
    }

    Column {
        LazyColumn {
            items(pokemons) { pokemon ->
                Text(text = pokemon.name)
            }
        }
    }


    
}