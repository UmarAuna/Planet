package com.example.planets.planet_v2.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.planets.R
import com.example.planets.model.Planet
import com.example.planets.planet_v2.util.DEFAULT_RECIPE_IMAGE
import com.example.planets.planet_v2.util.loadPicture
import com.example.planets.ui.theme.NewPlanetTheme
import com.example.planets.ui.theme.Typography

@Composable
fun PlanetDetailScreen(
    navController: NavHostController,
    planets: Planet,
    modifier: Modifier = Modifier
) {
    NewPlanetTheme {
        Surface(color = MaterialTheme.colors.background) {
            ScreenDetail(navController, planets)
        }
    }
}

@Composable
fun ScreenDetail(
    navController: NavHostController,
    planets: Planet,
    modifier: Modifier = Modifier
) {

    val scrollState = rememberScrollState()
    val resources = LocalContext.current.resources

    Column(
        modifier = Modifier
            .padding(15.dp)
            .fillMaxSize()

    ) {

        Row {
            Image(
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = "menu image",
                modifier = modifier
                    .align(Alignment.CenterVertically)
                    .clickable { navController.navigateUp() }
            )
        }

        Column(
            modifier
                .padding(21.dp, end = 5.dp)
                .fillMaxSize()
                .verticalScroll(scrollState)

        ) {

            Row(
                modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {

                Text(
                    text = planets.position.toString(),
                    color = Color(0x74E1DCDC),
                    style = Typography.Heading.heading1,
                    textAlign = TextAlign.Start,
                    modifier = modifier
                        .align(Alignment.CenterVertically)
                )

                planets.planetImage?.let { url ->
                    val image = loadPicture(url = url, defaultImage = DEFAULT_RECIPE_IMAGE).value
                    image?.let { img ->
                        Image(
                            bitmap = img.asImageBitmap(),
                            contentDescription = null,
                            contentScale = ContentScale.Fit,
                            modifier = modifier
                                .size(180.dp)

                        )
                    }
                }
            }

            planets.planetName?.let {
                Text(
                    text = it,
                    color = MaterialTheme.colors.onSurface,
                    style = Typography.Heading.heading2Bold,
                    textAlign = TextAlign.Start,
                )
            }
            planets.planetSummary?.let {
                Text(
                    text = it,
                    color = MaterialTheme.colors.onSurface,
                    style = Typography.Subtitle.subtitle1,
                    textAlign = TextAlign.Start,
                )
            }
            Spacer(modifier.height(8.dp))
            Divider()
            Spacer(modifier.height(5.dp))

            DetailScreenText(
                heading = "Surface Temperature",
                subHeading = "Approximately ${planets.surfaceTemperature}"
            )

            DetailScreenText(
                heading = "Distance from the Sun",
                subHeading = "${planets.distanceFromSun} from the Sun"
            )

            planets.discovery?.let { discovery ->
                DetailScreenText(
                    heading = "Discovery",
                    subHeading = discovery
                )
            }

            planets.originOfName?.let { named ->
                DetailScreenText(
                    heading = "Named",
                    subHeading = named
                )
            }

            planets.diameter?.let { diameter ->
                DetailScreenText(
                    heading = "Diameter",
                    subHeading = diameter
                )
            }

            planets.orbit?.let { orbit ->
                DetailScreenText(
                    heading = "Orbit",
                    subHeading = orbit
                )
            }

            planets.days?.let { days ->
                DetailScreenText(
                    heading = stringResource(R.string.days),
                    subHeading = days
                )
            }

            planets.moon?.let { moon ->
                DetailScreenText(
                    heading = "Moon",
                    subHeading = resources.getQuantityString(R.plurals.moon_quantity, moon, moon)
                )
            }
        }
    }
}

@Composable
fun DetailScreenText(
    heading: String,
    subHeading: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = heading,
        color = MaterialTheme.colors.onSurface,
        style = Typography.Subtitle.subtitle1Bold,
        textAlign = TextAlign.Start,
    )
    Text(
        text = subHeading,
        color = MaterialTheme.colors.onBackground,
        style = Typography.Caption.caption,
        textAlign = TextAlign.Start,
    )
    Spacer(modifier.height(12.dp))
}
