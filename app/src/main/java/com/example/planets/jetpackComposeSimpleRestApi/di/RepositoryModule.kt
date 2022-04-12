package com.example.planets.jetpackComposeSimpleRestApi.di

import com.example.planets.jetpackComposeSimpleRestApi.repository.PlanetRepository
import com.example.planets.jetpackComposeSimpleRestApi.repository.PlanetRepositoryImp
import com.example.planets.jetpackComposeSimpleRestApi.repository.UserRepository
import com.example.planets.jetpackComposeSimpleRestApi.repository.UserRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun userRepository(repo: UserRepositoryImp): UserRepository

    @Binds
    @Singleton
    abstract fun planetRepository(repo: PlanetRepositoryImp): PlanetRepository
}
