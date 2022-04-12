package com.example.planets.jetpackComposeSimpleRestApi.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.planets.R
import com.example.planets.jetpackComposeSimpleRestApi.model.User
import com.example.planets.planet_v2.util.loadPicture
import com.example.planets.ui.theme.PlanetsTheme
import com.valentinilk.shimmer.shimmer
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserView : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlanetsTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MyApp1()
                }
            }
        }
    }
}

@Composable
fun MyApp1(
    viewModel: UserViewModel = hiltViewModel()
) {
    val users by viewModel.users.observeAsState(arrayListOf())
    val isLoading by viewModel.isLoading.observeAsState(false)

    MyApp(onAddClick = {
        viewModel.addUser()
    }, onDeleteClick = {
            viewModel.deleteUser(it)
        }, users, isLoading, viewModel.errorMessage)
}

@Composable
fun MyApp(
    onAddClick: (() -> Unit)? = null,
    onDeleteClick: ((toDelete: User) -> Unit)? = null,
    users: List<User>,
    isLoading: Boolean,
    errorMessage: String,
) {
    val context = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Simple Rest + Room") },
                actions = {
                    IconButton(onClick = {
                        if (errorMessage.isEmpty()) {
                            onAddClick?.invoke()
                        } else {
                            Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show()
                        }
                    }) {
                        Icon(Icons.Filled.Add, "Add")
                    }
                }
            )
        }
    ) {
        LazyColumn {
            var itemCount = users.size
            if (isLoading) itemCount++

            items(count = itemCount) { index ->
                var auxIndex = index
                if (isLoading) {
                    if (auxIndex == 0)
                        return@items LoadingCard()
                    auxIndex--
                }
                val user = users[auxIndex]
                Card(
                    shape = RoundedCornerShape(8.dp),
                    elevation = 1.dp,
                    modifier = Modifier
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                        .fillMaxWidth(),
                ) {
                    Row(modifier = Modifier.padding(8.dp)) {
                        val image = loadPicture(url = user.thumbnail, defaultImage = R.drawable.placeholder).value
                        image?.let { it ->
                            Image(
                                bitmap = it.asImageBitmap(),
                                contentDescription = null,
                                contentScale = ContentScale.FillHeight,
                                modifier = Modifier.size(50.dp)
                            )
                        }
                       /* Image(
                            modifier = Modifier.size(50.dp),
                            painter = rememberImagePainter(
                                data = user.thumbnail,
                                builder = {
                                    placeholder(R.drawable.placeholder)
                                    error(R.drawable.placeholder)
                                }
                            ),
                            contentDescription = null,
                            contentScale = ContentScale.FillHeight
                        )*/
                        Spacer()
                        Column(
                            Modifier.weight(1f),
                        ) {
                            Text("${user.name} ${user.lastName}")
                            Text(user.city)
                        }
                        Spacer()
                        IconButton(onClick = {
                            onDeleteClick?.invoke(user)
                        }) {
                            Icon(Icons.Filled.Delete, "Remove")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun LoadingCard() {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 1.dp,
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .fillMaxWidth()
            .testTag("loadingCard")
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            ImageLoading()
            Spacer()
            Column {
                Spacer()
                Box(modifier = Modifier.shimmer()) {
                    Column {
                        Box(
                            modifier = Modifier
                                .height(15.dp)
                                .fillMaxWidth()
                                .background(Color.Gray)
                        )
                        Spacer()
                        Box(
                            modifier = Modifier
                                .height(15.dp)
                                .fillMaxWidth()
                                .background(Color.Gray)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ImageLoading() {
    Box(modifier = Modifier.shimmer()) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .background(Color.Gray)
        )
    }
}

@Composable
fun Spacer(size: Int = 8) = Spacer(modifier = Modifier.size(size.dp))

/*@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PlanetsTheme {
        MyApp(users = arrayListOf(), isLoading = true, errorMessage = viewModel.errorMessage)
    }
}*/
