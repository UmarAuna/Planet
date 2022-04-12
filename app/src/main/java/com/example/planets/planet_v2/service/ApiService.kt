package com.example.planets.planet_v2.service

import com.example.planets.model.Planet
import retrofit2.http.GET

interface ApiService {

    @GET("planets")
    suspend fun getPlanets(): List<Planet>
}
