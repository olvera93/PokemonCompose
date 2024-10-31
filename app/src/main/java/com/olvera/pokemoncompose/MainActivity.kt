package com.olvera.pokemoncompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.Text
import com.olvera.pokemoncompose.screens.home.PokemonListScreen
import com.olvera.pokemoncompose.screens.home.PokemonListViewModel
import com.olvera.pokemoncompose.ui.theme.PokemonComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val viewModel: PokemonListViewModel by viewModels()

        setContent {
            PokemonComposeTheme {
                PokemonListScreen(
                    viewModel = viewModel
                )
            }
        }
    }
}
