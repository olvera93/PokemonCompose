package com.olvera.pokemoncompose.screens.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.olvera.pokemoncompose.models.Result
import com.olvera.pokemoncompose.repository.PokemonRepository
import com.olvera.pokemoncompose.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {


    private val _pokemonList = MutableStateFlow<List<Result>>(emptyList())
    val pokemonList = _pokemonList

    fun getPokemonList() {
        viewModelScope.launch {
            val response = withContext(Dispatchers.IO) {
                repository.getPokemonList(limit = 60, offset = 0)
            }

            when (response) {
                is NetworkResult.Success -> {
                    response.data?.results?.let {
                        _pokemonList.value = it
                    } ?: run {
                        _pokemonList.value = emptyList()
                    }
                }
                is NetworkResult.Error -> {
                    Log.e("PokemonListViewModel", "Error fetching data: ${response.message}")
                    _pokemonList.value = emptyList()
                }

                is NetworkResult.Loading -> TODO()
            }
        }
    }
}