package com.example.planets.todo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.planets.screens.showToast
import com.example.planets.ui.theme.PlanetTheme

class TodoActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val viewModel = TodoViewModel()
        // viewModel.getTodoList()
        super.onCreate(savedInstanceState)
        setContent {
            PlanetTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    TodoView(viewModel)
                }
            }
        }
    }

    @Composable
    private fun TodoView(viewModel: TodoViewModel) {
        val loading = viewModel.loading.value
        // val todos by viewModel.observeTodoLists.observeAsState(emptyList())

        LaunchedEffect(Unit, block = {
            viewModel.getTodoList()
        })

        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Row {
                            Text("Todos")
                        }
                    }
                )
            },
            content = {
                if (viewModel.errorMessage.isEmpty()) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        DummyProgress(isDisplayed = loading)
                        LazyColumn(modifier = Modifier.fillMaxHeight()) {
                            items(viewModel.todoList /*todos*/) { todo ->

                                Column {
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(16.dp),
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(0.dp, 0.dp, 16.dp, 0.dp)
                                        ) {
                                            Text(
                                                todo.title,
                                                maxLines = 1,
                                                overflow = TextOverflow.Ellipsis,
                                                modifier = Modifier.clickable { showToast(applicationContext, todo.title) }
                                            )
                                        }
                                        Spacer(modifier = Modifier.width(16.dp))
                                        Checkbox(checked = todo.completed, onCheckedChange = null)
                                    }
                                    Divider()
                                }
                            }
                        }
                    }
                } else {
                    Text(
                        viewModel.errorMessage,
                        textAlign = TextAlign.Center,

                    )
                }
            }
        )
    }

    @Composable
    fun DummyProgress(isDisplayed: Boolean) {

        if (isDisplayed) {
            Dialog(
                onDismissRequest = { isDisplayed },
                DialogProperties(dismissOnBackPress = true, dismissOnClickOutside = true)
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(100.dp)
                        .background(White, shape = RoundedCornerShape(12.dp))
                ) {
                    Column {
                        CircularProgressIndicator(modifier = Modifier.padding(6.dp))
                        Text(text = "Loading...", Modifier.padding(0.dp, 8.dp, 0.dp, 0.dp))
                    }
                }
            }
        }
    }
}
