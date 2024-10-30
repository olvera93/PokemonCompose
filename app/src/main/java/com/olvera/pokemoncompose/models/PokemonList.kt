package com.olvera.pokemoncompose.models

data class PokemonList(

    val count: Long,
    val next: String,
    val previous: Any?,
    val results: List<Result>,
)
