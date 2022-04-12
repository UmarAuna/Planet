package com.example.planets.planet_v2.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.planets.model.Planet
import com.example.planets.planet_v2.route.Routes
import com.example.planets.planet_v2.viewModel.PlanetScreenViewModel
import com.example.planets.ui.theme.NewPlanetTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val viewModel = PlanetScreenViewModel()
        super.onCreate(savedInstanceState)
        setContent {
            NewPlanetTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    ScreenMain(viewModel)
                }
            }
        }
    }

    @Composable
    private fun ScreenMain(viewModel: PlanetScreenViewModel) {

        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = Routes.SplashScreenRoute.route
        ) {

            // First Route : SplashScreen
            composable(Routes.SplashScreenRoute.route) {
                SplashScreen(navController = navController)
            }

            // Second route : PlanetScreen
            composable(Routes.PlanetScreenRoute.route) {
                PlanetScreen(navController, viewModel)
            }

            // Third route : PlanetScreenDetail
            composable(Routes.PlanetScreenDetailRoute.route) {
                // Extracting the argument
                val planet = navController.previousBackStackEntry?.arguments?.getParcelable<Planet>("planet")

                // Lay down the PlanetScreen Composable
                // and pass the navController
                // Pass the extracted Planet
                planet?.let { planets ->
                    PlanetDetailScreen(navController, planets)
                    // PlanetDetailScreen(planets)
                }
            }
        }
    }
}
