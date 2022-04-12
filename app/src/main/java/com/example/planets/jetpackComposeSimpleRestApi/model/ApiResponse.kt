package com.example.planets.jetpackComposeSimpleRestApi.model

import androidx.lifecycle.LiveData
import androidx.room.*

data class ApiResponse(
    val results: List<Results> = emptyList(),
)
data class Results(
    val name: UserName?,
    val location: UserLocation?,
    val picture: UserPicture?,
)

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User)

    @Query("SELECT * FROM user ORDER BY id DESC")
    fun getAll(): LiveData<List<User>>

    @Delete
    fun delete(user: User)
}