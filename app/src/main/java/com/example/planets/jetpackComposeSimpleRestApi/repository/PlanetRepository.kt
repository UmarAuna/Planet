package com.example.planets.jetpackComposeSimpleRestApi.repository

import androidx.lifecycle.LiveData
import com.example.planets.jetpackComposeSimpleRestApi.datasource.RestDataSource
import com.example.planets.jetpackComposeSimpleRestApi.model.PlanetHome
import com.example.planets.jetpackComposeSimpleRestApi.model.PlanetHomeDao
import retrofit2.Response
import javax.inject.Inject

interface PlanetRepository {
    suspend fun getNewPlanet(): Response<List<PlanetHome>>
    suspend fun deletePlanet(toDelete: PlanetHome)
    fun getAllPlanets(): LiveData<List<PlanetHome>>
}

class PlanetRepositoryImp @Inject constructor(
    private val dataSource: RestDataSource,
    private val planetHomeDao: PlanetHomeDao
) : PlanetRepository {
    override suspend fun getNewPlanet(): Response<List<PlanetHome>> {
        val planets = dataSource.getPlanets()
        planetHomeDao.deleteAll()
        planets.body()?.let { planetHomeDao.insert(it) }
        return planets
    }

    override suspend fun deletePlanet(toDelete: PlanetHome) {
    }

    override fun getAllPlanets() = planetHomeDao.getAll()
}
