package com.example.planets.jetpackComposeSimpleRestApi.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.planets.jetpackComposeSimpleRestApi.model.User
import com.example.planets.jetpackComposeSimpleRestApi.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userRepo: UserRepository
) : ViewModel() {

    private val _isLoading: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>(false)
    }

    val isLoading: LiveData<Boolean> get() = _isLoading

    val users: LiveData<List<User>> by lazy {
        userRepo.getAllUsers()
    }

    var errorMessage: String by mutableStateOf("")

    fun addUser() {
        if (_isLoading.value == false) {
            viewModelScope.launch(Dispatchers.IO) {
                try {
                    _isLoading.postValue(true)
                    userRepo.getNewUser()
                    _isLoading.postValue(false)
                } catch (e: Exception) {
                    errorMessage = "No Internet Connection"
                }
            }
        }
    }

    fun deleteUser(toDelete: User) {
        viewModelScope.launch(Dispatchers.IO) {
            userRepo.deleteUser(toDelete)
        }
    }
}
