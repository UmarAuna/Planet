package com.example.planets.todo

import retrofit2.http.GET

interface ApiService {

    @GET("todos")
    suspend fun getTodos(): List<Todo>

   /* companion object {
       var loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(Level.BODY)

        var okHttpClient = OkHttpClient().newBuilder()
            .addInterceptor(loggingInterceptor)
            .build()

        init {

        }


        var apiService: ApiService? = null
        fun getInstance(): ApiService? {
            if (apiService == null) {
                apiService = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(ApiService::class.java)
            }
            return apiService
        }
    }*/
}
