package com.example.planets.planet_v2.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.planets.model.Planet
import com.example.planets.planet_v2.client.PlanetClient
import kotlinx.coroutines.launch

class PlanetScreenViewModel : ViewModel() {

   /* private val _planetList = mutableListOf<Planet>()
    val planetList: List<Planet>
        get() = _planetList*/

    private val _planetList = MutableLiveData<List<Planet>>()
    val planetList
        get() = _planetList

    val loading = mutableStateOf(false)

    var errorMessage: String by mutableStateOf("")

    fun getPlanetList() {
        viewModelScope.launch {
            loading.value = true
            val apiService = PlanetClient().getInstance()
            try {
                // _planetList.clear()
                // _planetList.addAll(apiService?.getPlanets() ?: return@launch)
                _planetList.postValue(apiService?.getPlanets())
            } catch (e: Exception) {
                errorMessage = "No Internet Connection"
            }
            loading.value = false
        }
    }
}
