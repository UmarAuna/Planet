package com.example.planets.jetpackComposeSimpleRestApi.di

import android.content.Context
import androidx.room.Room
import com.example.planets.jetpackComposeSimpleRestApi.datasource.DbDataSource
import com.example.planets.jetpackComposeSimpleRestApi.datasource.RestDataSource
import com.example.planets.jetpackComposeSimpleRestApi.model.PlanetHomeDao
import com.example.planets.jetpackComposeSimpleRestApi.model.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatasourceModule {

    @Singleton
    @Provides
    @Named("BaseUrl")
    fun provideBaseUrl() = "https://randomuser.me/api/"

    @Singleton
    @Provides
    fun provideRetrofit(@Named("BaseUrl") baseUrl: String, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .baseUrl(baseUrl)
            .build()
    }

    @Singleton
    @Provides
    fun providesHttpLoggingInterceptor() = HttpLoggingInterceptor()
        .apply {
            level = HttpLoggingInterceptor.Level.HEADERS
            level = HttpLoggingInterceptor.Level.BODY
        }

    @Singleton
    @Provides
    fun providesOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient
            .Builder()
            .addInterceptor(httpLoggingInterceptor)
            .readTimeout(40, TimeUnit.SECONDS)
            .connectTimeout(40, TimeUnit.SECONDS)
            .callTimeout(40, TimeUnit.SECONDS)
            .writeTimeout(40, TimeUnit.SECONDS)
            .build()

    @Singleton
    @Provides
    fun restDataSource(retrofit: Retrofit): RestDataSource = retrofit.create(RestDataSource::class.java)

    @Singleton
    @Provides
    fun dbDataSource(@ApplicationContext context: Context): DbDataSource {
        return Room.databaseBuilder(context, DbDataSource::class.java, "user_database")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun userDao(db: DbDataSource): UserDao = db.userDao()

    @Provides
    fun planetHomeDao(db: DbDataSource): PlanetHomeDao = db.planetHomeDao()
}
