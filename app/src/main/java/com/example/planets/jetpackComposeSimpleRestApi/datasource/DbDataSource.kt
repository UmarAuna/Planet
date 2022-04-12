package com.example.planets.jetpackComposeSimpleRestApi.datasource

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.planets.jetpackComposeSimpleRestApi.model.PlanetHome
import com.example.planets.jetpackComposeSimpleRestApi.model.PlanetHomeDao
import com.example.planets.jetpackComposeSimpleRestApi.model.User
import com.example.planets.jetpackComposeSimpleRestApi.model.UserDao

@Database(
    entities = [
        User::class,
        PlanetHome::class
    ],
    version = 2
)
abstract class DbDataSource : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun planetHomeDao(): PlanetHomeDao
}
