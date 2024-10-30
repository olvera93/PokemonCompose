package com.olvera.pokemoncompose.repository

import com.olvera.pokemoncompose.data.remote.PokemonApi
import com.olvera.pokemoncompose.models.PokemonList
import com.olvera.pokemoncompose.utils.NetworkResult
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokemonApi
) {

    suspend fun getPokemonList(
        limit: Int,
        offset: Int
    ): NetworkResult<PokemonList> {
        val response = try {
            api.getPokemonList(limit, offset)
        } catch (e: Exception) {
            return NetworkResult.Error("An unknown occurred.")
        }

        return NetworkResult.Success(response)
    }

}