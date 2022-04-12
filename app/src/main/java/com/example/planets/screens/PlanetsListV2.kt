package com.example.planets.screens

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.planets.model.Planets

@ExperimentalMaterialApi
@Composable
fun PlanetsListV2(planets: List<Planets>) {
    LazyColumn() {
        items(planets) { planet ->
            PlanetsListVector(planet)
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun PlanetsListVector(planet: Planets) {

    val context = LocalContext.current
    val (showDialog, setShowDialog) = rememberSaveable { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .clickable { /*setShowDialog(true)*/ }
                .padding(vertical = 10.dp, horizontal = 20.dp),
            backgroundColor = MaterialTheme.colors.primary,
            onClick = {
                val intent = Intent(context, PlanetDetails::class.java)
                intent.putExtra("PLANET", planet)
                context.startActivity(intent)
            }
        ) {
            Row {
                Image(
                    painter = painterResource(id = planet.icon),
                    contentDescription = planet.planetName,
                    modifier = Modifier.clip(MaterialTheme.shapes.medium)
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
        DialogDemo(showDialog, setShowDialog, planet)
    }
}
