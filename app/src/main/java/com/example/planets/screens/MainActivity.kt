package com.example.planets.screens

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.planets.R
import com.example.planets.model.PlanetData
import com.example.planets.model.Planets
import com.example.planets.ui.theme.NewPlanetTheme
import java.util.*

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewPlanetTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    // PlanetsList(planets = PlanetData.planetsList)
                    PlanetsList(planets = PlanetData.planetsListVector)
                }
            }
        }
    }
}

fun showToast(context: Context, msg: String) {
    Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
}

@ExperimentalMaterialApi
@Composable
fun PlanetsList(planets: List<Planets>) {
    // A surface container using the 'background' color from the theme
    Surface(color = MaterialTheme.colors.background) {
        Column() {
            Text(
                text = stringResource(R.string.planets),
                style = MaterialTheme.typography.h4,
                modifier = Modifier.padding(10.dp)
            )

            val planet = planets.maxByOrNull { it.moon }

            Text(
                text = getGreetingMessage(planet),
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(10.dp)
            )

            LazyColumn() {
                /*item {
                    TopAppBar(
                        title = {
                            Text(
                                text = stringResource(R.string.planets),
                                style = MaterialTheme.typography.h4
                            )
                        },
                        backgroundColor = Color.Transparent,
                        elevation = 2.dp
                    )
                }*/
                items(planets) { planet ->
                    PlanetImageList(planet)
                }
            }
        }
    }
}

@Composable
private fun getGreetingMessage(planet: Planets?): String {
    val c = Calendar.getInstance()
    val timeOfDay = c.get(Calendar.HOUR_OF_DAY)
    return when (timeOfDay) {
        in 0..11 -> {
            stringResource(R.string.good_morning)
        }
        in 12..15 -> {
            stringResource(R.string.good_afternoon)
        }
        in 16..20 -> {
            stringResource(R.string.good_evening, planet?.planetName!!, planet.moon)
        }
        in 21..23 -> {
            // vectorResource()
            // colorResource()
            stringResource(R.string.good_night)
        }
        else -> stringResource(R.string.hello)
    }
}

@ExperimentalMaterialApi
@Composable
fun PlanetImageList(planet: Planets) {

    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .padding(vertical = 10.dp, horizontal = 20.dp),
            backgroundColor = MaterialTheme.colors.primary,
            elevation = 12.dp,
            onClick = {
                val intent = Intent(context, PlanetDetails::class.java)
                intent.putExtra("PLANET", planet)
                context.startActivity(intent)
            }
        ) {
            Row {
                /*Image(
                    painter = painterResource(id = planet.icon),
                    contentDescription = planet.planetName,
                    modifier = Modifier.clip(MaterialTheme.shapes.medium)
                )*/
                Image(
                    painter = painterResource(id = planet.icon),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(8.dp)
                        .size(84.dp)
                        .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
                )
                Column(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Column(modifier = Modifier.fillMaxHeight(fraction = 0.5f)) {
                        Text(
                            text = planet.planetName,
                            color = MaterialTheme.colors.onSurface,
                            style = MaterialTheme.typography.h6,
                        )
                    }
                    Box(modifier = Modifier.fillMaxHeight(fraction = 0.5f)) {
                        Text(
                            text = "Days: ${planet.days}",
                            color = MaterialTheme.colors.onSurface,
                            style = MaterialTheme.typography.body2,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }
            }
        }
    }
}

@ExperimentalMaterialApi
@Preview(
    showBackground = true,
    // showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    name = "Light Mode Planets"
)
@Composable
@Preview(
    showBackground = true,
    //  showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Dark Mode Planets"
)
fun DefaultPreview3() {
    NewPlanetTheme {
        PlanetsList(planets = PlanetData.planetsListVector)
    }
}
