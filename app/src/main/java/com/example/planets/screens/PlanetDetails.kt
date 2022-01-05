package com.example.planets.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.example.planets.model.Planets
import com.example.planets.ui.theme.PlanetTheme

class PlanetDetails : ComponentActivity() {

    private val planet: Planets by lazy {
        intent?.getSerializableExtra("PLANET") as Planets
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlanetTheme {
                Surface(color = MaterialTheme.colors.background) {
                    PlanetScreen(planet)
                }
            }
        }
    }
}