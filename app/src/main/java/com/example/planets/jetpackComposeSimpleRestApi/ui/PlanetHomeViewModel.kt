package com.example.planets.jetpackComposeSimpleRestApi.ui

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.*
import com.example.planets.jetpackComposeSimpleRestApi.datasource.Network
import com.example.planets.jetpackComposeSimpleRestApi.model.PlanetHome
import com.example.planets.jetpackComposeSimpleRestApi.model.PlanetHomeDao
import com.example.planets.jetpackComposeSimpleRestApi.repository.PlanetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlanetHomeViewModel @Inject constructor(
    private val planetRepo: PlanetRepository,
    private val planetHomeDao: PlanetHomeDao,
    @ApplicationContext private val context: Context
) : ViewModel() {

    // val data = planetHomeDao.getAll()

    private val _isLoading: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>(false)
    }

    val isLoading: LiveData<Boolean> get() = _isLoading

    val planets: LiveData<List<PlanetHome>> by lazy {
        planetRepo.getAllPlanets()
    }

    val observePlanet
        get() = Transformations.map(planetHomeDao.getAll()) {
            it
        }

    var errorMessage: String by mutableStateOf("")

    fun getPlanets() {
        _isLoading.postValue(true)
        if (Network().isNetworkConnected(context)) {
            viewModelScope.launch(Dispatchers.IO) {

                try {
                    /* _isLoading.postValue(true)
                     planetRepo.getNewPlanet()
                     _isLoading.postValue(false)*/

                    val response = planetRepo.getNewPlanet()
                    _isLoading.postValue(false)
                    if (response.isSuccessful) {
                        response.body()
                    } else {
                        errorMessage = when (response.code()) {
                            404 -> {
                                // observeError.postValue("Not Found")
                                "Not Found"
                            }
                            500 -> {
                                // observeError.postValue("Server Broken")
                                "Server Broken"
                            }
                            else -> {
                                // observeError.postValue("Unknown Error")
                                "Unknown Error"
                            }
                        }
                    }
                } catch (e: Exception) {
                    // errorMessage = "No Internet Connection"
                    e.printStackTrace()
                }
            }
        } else {
            errorMessage = "No Internet"
        }
    }
}
