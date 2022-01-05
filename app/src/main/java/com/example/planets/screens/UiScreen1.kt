package com.example.planets.screens

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.* // ktlint-disable no-wildcard-imports
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.planets.R
import com.example.planets.ui.theme.PlanetTheme

@Composable
@Preview
fun PhotographCard(modifier: Modifier = Modifier) {
    Row(
        modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(4.dp))
            .background(MaterialTheme.colors.surface)
            .clickable { }
            .padding(16.dp)

    ) {
        Surface(
            modifier.size(50.dp),
            shape = CircleShape,
            color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
        ) {
        }

        Column(
            modifier
                .padding(start = 8.dp)
                .align(Alignment.CenterVertically)
        ) {
            Text(text = "Alfred Sisley", fontWeight = FontWeight.Bold)

            // LocalContentAlpha is defining opacity level of its children
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Text("3 minutes ago", style = MaterialTheme.typography.body2)
            }
        }
    }
}

@Composable
fun Display() {
    val context = LocalContext.current
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier
            .padding(10.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(MaterialTheme.colors.background)
            .clickable { showToast(context, "Hello World") }
            .padding(8.dp)
    ) {
        Row(
            /*modifier = Modifier
                .padding(8.dp)
                .clip(RoundedCornerShape(4.dp))
                .background(MaterialTheme.colors.background)
                .clickable { }
                .padding(8.dp)*/

        ) {
            Image(
                painter = painterResource(R.drawable.neptune),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(top = 5.dp)
                    .size(70.dp)
                    .padding(top = 2.dp)
                    .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 18.dp)
                    .align(Alignment.CenterVertically)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                ) {
                    Text(
                        text = "Parkinson",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .align(Alignment.TopStart)
                            .padding(top = 2.dp),
                        style = MaterialTheme.typography.body1
                    )
                    Text(
                        text = "Male",
                        fontWeight = FontWeight.Light,
                        style = MaterialTheme.typography.caption,
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .background(
                                color = Color(0x36006AF6),
                                shape = RoundedCornerShape(CornerSize(10.dp))
                            )
                            .padding(start = 12.dp, end = 12.dp, top = 5.dp, bottom = 5.dp),
                        color = Color(0xFF006AF6)
                    )
                }

                Spacer(modifier = Modifier.height(5.dp))

                Text(text = "2 yrs | Playful", fontWeight = FontWeight.Light)

                Spacer(modifier = Modifier.height(5.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                ) {
                    Row() {
                        Image(
                            painter = painterResource(R.drawable.ic_baseline_location),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .padding(top = 5.dp)
                                .size(15.dp)
                                .padding(top = 2.dp)
                                .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "381m away",
                            fontWeight = FontWeight.Light,
                            modifier = Modifier
                                .padding(top = 5.dp),
                            style = MaterialTheme.typography.caption
                        )
                    }

                    Text(
                        text = "12 min ago",
                        fontWeight = FontWeight.Light,
                        style = MaterialTheme.typography.caption,
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(start = 12.dp, top = 5.dp, bottom = 5.dp),
                    )
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
    name = "Light Mode"
)
@Composable
@Preview(
    showBackground = true,
    //  showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Dark Mode"
)
fun ShowPreview() {
    PlanetTheme {
        Display()
    }
}
