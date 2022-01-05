package com.example.planets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.example.planets.model.Planets

@Composable
fun DialogDemo(showDialog: Boolean, setShowDialog: (Boolean) -> Unit, planet: Planets) {
    if (showDialog) {
        AlertDialog(
            onDismissRequest = {
            },
            title = {
                Text(planet.planetName)
            },
            confirmButton = {
                Button(
                    onClick = {
                        // Change the state to close the dialog
                        setShowDialog(false)
                    },
                ) {
                    Text("Confirm")
                }
            },
            dismissButton = {
                Button(
                    onClick = {
                        // Change the state to close the dialog
                        setShowDialog(false)
                    },
                ) {
                    Text("Dismiss")
                }
            },
            text = {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

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
                    Spacer(modifier = Modifier.height(2.dp))
                    Image(
                        painter = painterResource(id = planet.icon),
                        contentDescription = planet.planetName,
                        modifier = Modifier.clip(MaterialTheme.shapes.medium),
                        contentScale = ContentScale.Crop,
                    )
                }
            }
        )
    }
}
