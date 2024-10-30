package com.olvera.pokemoncompose.data.remote

import com.olvera.pokemoncompose.models.PokemonList
import com.olvera.pokemoncompose.utils.Constants.ENDPOINT_POKEMON_LIST
import com.olvera.pokemoncompose.utils.Urls.BASE_URL
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonApi {


    @GET(BASE_URL+ENDPOINT_POKEMON_LIST)
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): PokemonList

}