package com.example.planets.planet_v2.route

/*sealed class Routes(val route: String) {
    object Home : Routes("home")
    object Profile : Routes("profile")
    object Settings : Routes("setting")
}*/

sealed class Routes(val route: String) {
    object SplashScreenRoute : Routes("splash_screen_route")
    object PlanetScreenRoute : Routes("planet_screen_route")
    object PlanetScreenDetailRoute : Routes("planet_screen_detail_route")
}
