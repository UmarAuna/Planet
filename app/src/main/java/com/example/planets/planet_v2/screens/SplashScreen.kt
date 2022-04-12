package com.example.planets.planet_v2.screens

import android.content.res.Configuration
import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.planets.R
import com.example.planets.planet_v2.route.Routes
import com.example.planets.ui.theme.NewPlanetTheme
import com.example.planets.ui.theme.Typography
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {

    val scale = remember {
        Animatable(0f)
    }

    Box {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(R.drawable.splashscreen_wallpaper),
            contentDescription = "background_image",
            contentScale = ContentScale.FillBounds
        )

        Column(
            modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            // horizontlAlignment = Alignment.CenterHorizontally
        ) {

            // Animation
            LaunchedEffect(key1 = true) {
                scale.animateTo(
                    targetValue = 0.7f,
                    // tween Animation
                    animationSpec = tween(
                        durationMillis = 800,
                        easing = {
                            OvershootInterpolator(4f).getInterpolation(it)
                        }
                    )
                )
                // Customize the delay time
                delay(3000L)
                navController.navigate(Routes.PlanetScreenRoute.route) {
                    popUpTo(Routes.SplashScreenRoute.route) {
                        inclusive = true
                    }
                }
            }

            Text(
                text = "Know about the",
                modifier = Modifier
                    .fillMaxWidth()
                    .scale(scale.value),
                style = Typography.Heading.heading6Bold.copy(Color.White),
                textAlign = TextAlign.Center
            )
            Text(
                text = "UNIVERSE",
                modifier = Modifier
                    .fillMaxWidth()
                    .scale(scale.value),
                style = Typography.Heading.heading2Bold.copy(Color.White),
                textAlign = TextAlign.Center
            )
            Text(
                text = "In a GLANCE",
                modifier = Modifier
                    .fillMaxWidth()
                    .scale(scale.value),
                style = Typography.Heading.heading6Bold.copy(Color.White),
                textAlign = TextAlign.Center
            )
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
fun PreviewSplashScreen() {
    val navController = rememberNavController()
    NewPlanetTheme {
        SplashScreen(navController)
    }
}
