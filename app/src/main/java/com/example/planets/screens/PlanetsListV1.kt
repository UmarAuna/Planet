package com.example.planets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.example.planets.model.Planets

@Composable
fun PlanetsListV1(planets: List<Planets>) {
    LazyColumn() {
        items(planets) { planet ->
            PlanetView(planet)
        }
    }
}

@Composable
fun PlanetView(planet: Planets) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Surface(shape = RoundedCornerShape(10.dp), elevation = 8.dp) {
            Column(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(id = planet.icon),
                    contentDescription = planet.planetName,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentScale = ContentScale.Crop

                )
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        planet.planetName,
                        color = MaterialTheme.colors.onSurface,
                        style = MaterialTheme.typography.h5,
                        fontFamily = FontFamily.Monospace
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        "Surface Temperature : ${planet.surfaceTemperature}",
                        color = MaterialTheme.colors.onSurface,
                        style = MaterialTheme.typography.body1,
                        fontFamily = FontFamily.SansSerif
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        "Discovery : ${planet.discovery}",
                        color = MaterialTheme.colors.onSurface,
                        style = MaterialTheme.typography.body1,
                        fontFamily = FontFamily.SansSerif
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        "Named : ${planet.originOfName}",
                        color = MaterialTheme.colors.onSurface,
                        style = MaterialTheme.typography.body1,
                        fontFamily = FontFamily.SansSerif
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        "Diameter : ${planet.diameter}",
                        color = MaterialTheme.colors.onSurface,
                        style = MaterialTheme.typography.body1,
                        fontFamily = FontFamily.SansSerif
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        "Orbit : ${planet.orbit}",
                        color = MaterialTheme.colors.onSurface,
                        style = MaterialTheme.typography.body1,
                        fontFamily = FontFamily.SansSerif
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        "Days : ${planet.days}",
                        color = MaterialTheme.colors.onSurface,
                        style = MaterialTheme.typography.body1,
                        fontFamily = FontFamily.SansSerif
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        "Moon : ${planet.moon}",
                        color = MaterialTheme.colors.onSurface,
                        style = MaterialTheme.typography.body1,
                        fontFamily = FontFamily.SansSerif
                    )
                }
            }
        }
    }
}
