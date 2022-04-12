package com.example.planets.jetpackComposeSimpleRestApi.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.planets.R
import com.example.planets.planet_v2.components.PlanetProgressIndicator
import com.example.planets.ui.theme.PlanetsTheme
import com.skydoves.landscapist.glide.GlideImage
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PlanetHomeView : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlanetsTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    PlanetHomeScreen()
                }
            }
        }
    }
}

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun PlanetHomeScreen(
    viewModel: PlanetHomeViewModel = hiltViewModel()
) {

    LaunchedEffect(Unit, block = {
        viewModel.getPlanets()
    })
    val planets by viewModel.planets.observeAsState(arrayListOf())
    val observePlanet by viewModel.observePlanet.observeAsState(listOf())
    val isLoading by viewModel.isLoading.observeAsState(false)
    val context = LocalContext.current
    val snackState = remember { SnackbarHostState() }
    val snackScope = rememberCoroutineScope()
    val isEmpty = isEmpty(observePlanet)

    Column(
        modifier = Modifier
            .padding(top = 52.dp, start = 20.dp, end = 20.dp)
    ) {
     /*   Text(
            text = stringResource(R.string.message),
            color = Color(0xFFFFFFFF),
            style = Typography.Body.body1Harbour,
            textAlign = TextAlign.Start,
        )*/

       /* val image = loadPicture(defaultImage = R.drawable.planet_greeting, url = "https://res.cloudinary.com/dxrxviiv8/image/upload/w_1000,ar_16:9,c_fill,g_auto,e_sharpen/v1649341730/quran-lyfe/q1.png").value

        image?.let {
            Image(
                bitmap = it.asImageBitmap(),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(500.dp)
            )
        }*/

        Text(
            text = "${viewModel.errorMessage} ${if (isEmpty) "Is Empty" else "Not Empty"} ",

            textAlign = TextAlign.Center,
        )
        SnackbarHost(hostState = snackState, Modifier)


        if (viewModel.errorMessage.isEmpty()) {
            PlanetProgressIndicator(isDisplayed = isLoading)
            LazyColumn {
                /* items(planets) { planet ->
                     planet.planetName?.let { Text(text = it) }
                 }*/
                items(observePlanet) { planet ->
                    planet.planetName?.let { Text(text = it) }
                    GlideImage(
                        imageModel = planet.planetImage,
                        // Crop, Fit, Inside, FillHeight, FillWidth, None
                        contentScale = ContentScale.Fit,
                        // shows a placeholder while loading the image.
                        placeHolder = ImageBitmap.imageResource(R.drawable.placeholder),
                        // shows an error ImageBitmap when the request failed.
                        error = ImageBitmap.imageResource(R.drawable.placeholder),
                        modifier = Modifier
                            .padding(8.dp)
                            .size(50.dp)
                            .clip(RoundedCornerShape(corner = CornerSize(16.dp))),
                        requestOptions = {
                            RequestOptions()
                                .override(256, 256)
                                .diskCacheStrategy(DiskCacheStrategy.ALL)
                                .centerCrop()
                        }
                    )
                }
            }
        } else {

            LazyColumn {
                    /* items(planets) { planet ->
                         planet.planetName?.let { Text(text = it) }
                     }*/
                items(observePlanet) { planet ->
                    planet.planetName?.let { Text(text = it) }
                    GlideImage(
                        imageModel = planet.planetImage,
                        // Crop, Fit, Inside, FillHeight, FillWidth, None
                        contentScale = ContentScale.Fit,
                        // shows a placeholder while loading the image.
                        placeHolder = ImageBitmap.imageResource(R.drawable.placeholder),
                        // shows an error ImageBitmap when the request failed.
                        error = ImageBitmap.imageResource(R.drawable.placeholder),
                        modifier = Modifier
                            .padding(8.dp)
                            .size(50.dp)
                            .clip(RoundedCornerShape(corner = CornerSize(16.dp))),
                        requestOptions = {
                            RequestOptions()
                                .override(256, 256)
                                .diskCacheStrategy(DiskCacheStrategy.ALL)
                                .centerCrop()
                        }
                    )
                }
            }
            Toast.makeText(context, viewModel.errorMessage, Toast.LENGTH_SHORT).show()
            snackScope.launch { snackState.showSnackbar(viewModel.errorMessage) }
        }
    }
}

fun isEmpty(list: List<*>?): Boolean {
    return list != null && list.isEmpty()
}
