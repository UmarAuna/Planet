package com.example.planets.planet_v2.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.planets.R
import com.example.planets.model.Planet
import com.example.planets.planet_v2.util.loadPicture
import com.example.planets.ui.theme.Typography
import java.util.*

@Composable
fun PlanetGreetingDialog(
    planets: List<Planet>,
    isDialogOpen: MutableState<Boolean>,
    modifier: Modifier = Modifier
) {

    val planet = planets.maxByOrNull { planetWithHighestMoon ->
        planetWithHighestMoon.moon ?: 0
    }

    if (isDialogOpen.value) {
        Dialog(onDismissRequest = { isDialogOpen.value = false }) {
            Surface(
                modifier = modifier
                    .width(650.dp)
                    .height(350.dp)
                    .padding(5.dp),
                shape = RoundedCornerShape(8.dp),
                color = MaterialTheme.colors.background
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    val image = loadPicture(defaultImage = R.drawable.planet_greeting, url = "https://i.gifer.com/1KOC.gif").value

                    image?.let {
                        Image(
                            bitmap = it.asImageBitmap(),
                            contentDescription = null,
                            contentScale = ContentScale.Fit,
                            modifier = modifier.size(180.dp)
                        )
                    }

                    Text(
                        text = getGreetingMessage(planet = planet),
                        color = MaterialTheme.colors.onBackground,
                        textAlign = TextAlign.Center,
                        style = Typography.Body.body1,
                        modifier = modifier.padding(5.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun getGreetingMessage(planet: Planet?): String {
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
            stringResource(R.string.good_evening, planet?.planetName ?: 0, planet?.moon ?: 0)
        }
        in 21..23 -> {
            stringResource(R.string.good_night)
        }
        else -> stringResource(R.string.hello)
    }
}
