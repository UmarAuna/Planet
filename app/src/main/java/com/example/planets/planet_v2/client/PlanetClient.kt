package com.example.planets.planet_v2.client

import android.util.Log
import com.example.planets.planet_v2.service.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PlanetClient {

    fun getInstance(): ApiService? {
        val interceptor = HttpLoggingInterceptor { message -> Log.d("com.planet.log.http", message) }
        interceptor.level = HttpLoggingInterceptor.Level.HEADERS
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client: OkHttpClient = OkHttpClient()
            .newBuilder()
            .addNetworkInterceptor(interceptor)
            .addInterceptor(interceptor)
            .build()

        var apiService: ApiService? = null
        if (apiService == null) {
            apiService = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(ApiService::class.java)
        }
        return apiService
    }

    companion object {
        const val BASE_URL = "https://jarida-spring.herokuapp.com/api/v1/"
    }
}
