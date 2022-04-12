package com.example.planets.planet_v2.screens

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.planets.R
import com.example.planets.model.Planet
import com.example.planets.planet_v2.components.PlanetProgressIndicator
import com.example.planets.planet_v2.route.Routes
import com.example.planets.planet_v2.util.DEFAULT_RECIPE_IMAGE
import com.example.planets.planet_v2.util.loadPicture
import com.example.planets.planet_v2.viewModel.PlanetScreenViewModel
import com.example.planets.ui.theme.NewPlanetTheme
import com.example.planets.ui.theme.Typography

@Composable
fun PlanetScreen(
    navController: NavHostController,
    viewModel: PlanetScreenViewModel,
    modifier: Modifier = Modifier,
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val loading = viewModel.loading.value

        LaunchedEffect(Unit, block = {
            viewModel.getPlanetList()
        })

        if (viewModel.errorMessage.isEmpty()) {
            PlanetProgressIndicator(isDisplayed = loading)
            viewModel.planetList.value?.let { planets ->
                PlanetScreenItem(planets, navController)
            }
        } else {
            Text(
                viewModel.errorMessage,
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Composable
fun PlanetScreenItem(
    data: List<Planet>,
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    val isDialogOpen = remember { mutableStateOf(false) }
    PlanetGreetingDialog(data, isDialogOpen)

    Column(
        modifier = modifier
            .padding(top = 52.dp, start = 20.dp, end = 20.dp)
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_menu),
                contentDescription = "menu image",
                modifier = modifier.align(Alignment.CenterVertically)
            )
            Text(
                text = "Discover",
                color = MaterialTheme.colors.onSurface,
                style = Typography.Heading.heading6Bold,
                textAlign = TextAlign.Center
            )

            Image(
                painter = painterResource(id = R.drawable.ic_info),
                contentDescription = "menu image",
                modifier = modifier
                    .align(Alignment.CenterVertically)
                    .clickable {
                        isDialogOpen.value = true
                        // setShowDialog(true)
                        // navController.navigate(Routes.PlanetScreenGreetingRoute.route)
                    }
            )
        }

        Spacer(modifier = modifier.height(10.dp))

        LazyColumn {
            items(data) { planets ->
                PlanetScreenItems(planets, navController)
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PlanetScreenItems(
    planet: Planet,
    navController: NavHostController,
    modifier: Modifier = Modifier
) {

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        backgroundColor = MaterialTheme.colors.primary,
        elevation = 10.dp,
        onClick = {
            navController.currentBackStackEntry?.arguments?.putParcelable("planet", planet)
            navController.navigate(Routes.PlanetScreenDetailRoute.route)
        }
    ) {
        Row {
            planet.planetImage?.let { url ->
                val image = loadPicture(url = url, defaultImage = DEFAULT_RECIPE_IMAGE).value
                image?.let { img ->
                    Image(
                        bitmap = img.asImageBitmap(),
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        modifier = modifier
                            .padding(8.dp)
                            .size(50.dp)
                            .align(Alignment.CenterVertically)
                            .clip(RoundedCornerShape(corner = CornerSize(16.dp)))

                    )
                }
            }
            Column(
                modifier
                    .padding(top = 12.dp, bottom = 12.dp)
                    .align(Alignment.CenterVertically)
            ) {
                planet.planetName?.let { planetName ->
                    Text(
                        text = planetName,
                        color = MaterialTheme.colors.onSurface,
                        style = Typography.Body.body1Bold,
                        textAlign = TextAlign.Start
                    )
                }

                Text(
                    text = "${planet.distanceFromSun} from the sun",
                    color = MaterialTheme.colors.onBackground,
                    style = Typography.Caption.caption,
                    textAlign = TextAlign.Start
                )

                Text(
                    text = "Days: ${planet.days}",
                    color = MaterialTheme.colors.onBackground,
                    style = Typography.Caption.caption,
                    textAlign = TextAlign.Start
                )
            }

            Box {
                Text(
                    text = planet.position.toString(),
                    color = Color(0x74E1DCDC),
                    style = Typography.Heading.heading3,
                    textAlign = TextAlign.End,
                    modifier = modifier
                        .padding(start = 50.dp)
                    /*.align(Alignment.CenterVertically)*/
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    // showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    name = "Light Mode Planets"
)
@Preview(
    showBackground = true,
    //  showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Dark Mode Planets"
)
@Composable
fun PreviewPlanetScreen() {
    val navController = rememberNavController()
    NewPlanetTheme {
        // PlanetScreenItem()
        // PlanetScreen(navController = navController, PlanetData.planet)
    }
}
