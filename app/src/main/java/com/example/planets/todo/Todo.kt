package com.example.planets.todo

data class Todo(
    val userId: Int,
    val id: Int,
    val title: String,
    val completed: Boolean
)

const val BASE_URL = "https://jsonplaceholder.typicode.com/"
