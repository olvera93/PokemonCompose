package com.olvera.pokemoncompose.repository

import com.olvera.pokemoncompose.data.remote.PokemonApi
import com.olvera.pokemoncompose.models.PokemonList
import com.olvera.pokemoncompose.utils.NetworkResult
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val api: PokemonApi
) {

    suspend fun getPokemonList(
        limit: Int,
        offset: Int
    ): NetworkResult<PokemonList> {
        return try {
            val response = api.getPokemonList(limit, offset)
            NetworkResult.Success(response)
        } catch (e: HttpException) {
            NetworkResult.Error("HTTP error: ${e.code()} - ${e.message()}")
        } catch (e: IOException) {
            NetworkResult.Error("Network error: ${e.message}")
        } catch (e: Exception) {
            NetworkResult.Error("An unknown error occurred: ${e.message}")
        }
    }
}
