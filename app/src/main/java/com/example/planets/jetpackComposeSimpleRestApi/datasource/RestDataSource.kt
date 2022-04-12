package com.example.planets.jetpackComposeSimpleRestApi.datasource

import com.example.planets.jetpackComposeSimpleRestApi.model.ApiResponse
import com.example.planets.jetpackComposeSimpleRestApi.model.PlanetHome
import retrofit2.Response
import retrofit2.http.GET

interface RestDataSource {

    @GET("?inc=name")
    suspend fun getUserName(): Response<ApiResponse>

    @GET("?inc=location")
    suspend fun getUserLocation(): Response<ApiResponse>

    @GET("?inc=picture")
    suspend fun getUserPicture(): Response<ApiResponse>

    @GET("https://jarida-spring.herokuapp.com/api/v1/planets")
    suspend fun getPlanets(): Response<List<PlanetHome>>
}
