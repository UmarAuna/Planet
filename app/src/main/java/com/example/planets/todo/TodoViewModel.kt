package com.example.planets.todo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class TodoViewModel : ViewModel() {

    private val _todoList = mutableStateListOf<Todo>()
    val todoList: List<Todo>
        get() = _todoList

    private val _todoListFlow = MutableStateFlow<List<Todo>>()
    val observeTodoListsFlow
        get() = _todoListFlow

  /*  private val _todoLists = MutableLiveData<List<Todo>>()
    val observeTodoLists
        get() = _todoLists*/

    val loading = mutableStateOf(false)

    var errorMessage: String by mutableStateOf("")

    fun getTodoList() {
        viewModelScope.launch {
            loading.value = true
            delay(3000)
            // val apiService = ApiService.getInstance()
            val apiService = TodoClient().getInstance()
            try {
                _todoList.clear()
                _todoList.addAll(apiService?.getTodos() ?: return@launch)
                // _todoLists.postValue(apiService?.getTodos())
            } catch (e: Exception) {
                // errorMessage = e.message.toString()
                errorMessage = "No Internet Connection"
            }
            loading.value = false
        }
    }
}
