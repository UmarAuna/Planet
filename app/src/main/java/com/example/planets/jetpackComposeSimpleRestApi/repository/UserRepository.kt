package com.example.planets.jetpackComposeSimpleRestApi.repository

import androidx.lifecycle.LiveData
import com.example.planets.jetpackComposeSimpleRestApi.datasource.RestDataSource
import com.example.planets.jetpackComposeSimpleRestApi.model.User
import com.example.planets.jetpackComposeSimpleRestApi.model.UserDao
import kotlinx.coroutines.delay
import javax.inject.Inject

interface UserRepository {
    suspend fun getNewUser(): User
    suspend fun deleteUser(toDelete: User)
    fun getAllUsers(): LiveData<List<User>>
}

class UserRepositoryImp @Inject constructor(
    private val dataSource: RestDataSource,
    private val userDao: UserDao
) : UserRepository {

    override suspend fun getNewUser(): User {
        delay(3000)
        // val name = dataSource.getUserName().results[0].name!!
        val name = dataSource.getUserName().body()?.results?.get(0)?.name
      /*  val name = dataSource.getUserName().let {
            it.body()?.results?.get(0)?.name
        }*/
        val location = dataSource.getUserName().body()?.results?.get(0)?.location
        // val location = dataSource.getUserLocation().results[0].location!!
        /*val location = dataSource.getUserLocation().let {
            it.body()?.results?.get(0)?.location
        }*/
        // val picture = dataSource.getUserPicture().results[0].picture
        val picture = dataSource.getUserName().body()?.results?.get(0)?.picture
      /*  val picture = dataSource.getUserPicture().let {
            it.body()?.results?.get(0)?.picture
        }*/
        // val user = User(name.first, name.last, location.city, picture.thumbnail)
        val user = User(name!!.first, name.last, location!!.city, picture!!.thumbnail)
        userDao.insert(user)
        return user
    }

    override suspend fun deleteUser(toDelete: User) = userDao.delete(toDelete)

    override fun getAllUsers() = userDao.getAll()
}
