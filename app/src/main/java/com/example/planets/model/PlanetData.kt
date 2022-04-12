package com.example.planets.model

import com.example.planets.R

object PlanetData {

    val planetsList = listOf(
        Planets(
            planetName = "Mercury",
            icon = R.drawable.mercury,
            surfaceTemperature = "-173 - 427 °C",
            discovery = "Known to the ancient Greeks and visible to the naked eye",
            originOfName = "Named for the messenger of the Roman gods",
            diameter = " 3,031 miles (4,878 km)",
            orbit = "88 Earth days",
            days = "58.6 Earth days",
            moon = 0
        ),
        Planets(
            planetName = "Venus",
            icon = R.drawable.venus,
            surfaceTemperature = "462 °C",
            discovery = "Known to the ancient Greeks and visible to the naked eye",
            originOfName = "Named for the Roman goddess of love and beauty",
            diameter = "7,521 miles (12,104 km)",
            orbit = "225 Earth days",
            days = "241 Earth days",
            moon = 0
        ),
        Planets(
            planetName = "Earth",
            icon = R.drawable.earth,
            surfaceTemperature = " -88 - 58 °C",
            discovery = "",
            originOfName = "Die Erde,\" the German word for \"the ground.",
            diameter = "7,926 miles (12,760 km)",
            orbit = "365.24 days",
            days = "23 hours, 56 minutes",
            moon = 1
        ),
        Planets(
            planetName = "Mars",
            icon = R.drawable.mars,
            surfaceTemperature = "-63 °C",
            discovery = "Known to the ancient Greeks and visible to the naked eye",
            originOfName = "Named for the Roman god of wa",
            diameter = "4,217 miles (6,787 km)",
            orbit = "687 Earth days",
            days = " Just more than one Earth day (24 hours, 37 minutes)",
            moon = 2
        ),
        Planets(
            planetName = "Jupiter",
            icon = R.drawable.jupiter,
            surfaceTemperature = "-108 °C",
            discovery = "Known to the ancient Greeks and visible to the naked eye",
            originOfName = "Named for the ruler of the Roman gods",
            diameter = "86,881 miles (139,822 km)",
            orbit = "11.9 Earth years",
            days = "9.8 Earth hours",
            moon = 79
        ),
        Planets(
            planetName = "Saturn",
            icon = R.drawable.saturn,
            surfaceTemperature = "-139 °C",
            discovery = "Known to the ancient Greeks and visible to the naked eye",
            originOfName = "Named for Roman god of agriculture",
            diameter = "74,900 miles (120,500 km)",
            orbit = "29.5 Earth years",
            days = "About 10.5 Earth hours",
            moon = 82
        ),
        Planets(
            planetName = "Uranus",
            icon = R.drawable.uranus,
            surfaceTemperature = "-197 °C",
            discovery = "1781 by William Herschel (was originally thought to be a star)",
            originOfName = "Named for the personification of heaven in ancient myth",
            diameter = " 31,763 miles (51,120 km)",
            orbit = "84 Earth years",
            days = "18 Earth hours",
            moon = 27
        ),
        Planets(
            planetName = "Neptune",
            icon = R.drawable.neptune,
            surfaceTemperature = "-201 °C",
            discovery = "1846",
            originOfName = "Named for the Roman god of water",
            diameter = "30,775 miles (49,530 km)",
            orbit = "165 Earth years",
            days = "19 Earth hours",
            moon = 14
        )
    )

    val planetsListVector = listOf(
        Planets(
            planetName = "Mercury",
            icon = R.drawable.ic_planet_mercury,
            surfaceTemperature = "-173 - 427 °C",
            discovery = "Known to the ancient Greeks and visible to the naked eye",
            originOfName = "Named for the messenger of the Roman gods",
            diameter = " 3,031 miles (4,878 km)",
            orbit = "88 Earth days",
            days = "58.6 Earth days",
            moon = 0
        ),
        Planets(
            planetName = "Venus",
            icon = R.drawable.ic_planet_venus,
            surfaceTemperature = "462 °C",
            discovery = "Known to the ancient Greeks and visible to the naked eye",
            originOfName = "Named for the Roman goddess of love and beauty",
            diameter = "7,521 miles (12,104 km)",
            orbit = "225 Earth days",
            days = "241 Earth days",
            moon = 0
        ),
        Planets(
            planetName = "Earth",
            icon = R.drawable.ic_planet_earth,
            surfaceTemperature = " -88 - 58 °C",
            discovery = "",
            originOfName = "Die Erde,\" the German word for \"the ground.",
            diameter = "7,926 miles (12,760 km)",
            orbit = "365.24 days",
            days = "23 hours, 56 minutes",
            moon = 1
        ),
        Planets(
            planetName = "Mars",
            icon = R.drawable.ic_planet_mars,
            surfaceTemperature = "-63 °C",
            discovery = "Known to the ancient Greeks and visible to the naked eye",
            originOfName = "Named for the Roman god of wa",
            diameter = "4,217 miles (6,787 km)",
            orbit = "687 Earth days",
            days = " Just more than one Earth day (24 hours, 37 minutes)",
            moon = 2
        ),
        Planets(
            planetName = "Jupiter",
            icon = R.drawable.ic_planet_jupiter,
            surfaceTemperature = "-108 °C",
            discovery = "Known to the ancient Greeks and visible to the naked eye",
            originOfName = "Named for the ruler of the Roman gods",
            diameter = "86,881 miles (139,822 km)",
            orbit = "11.9 Earth years",
            days = "9.8 Earth hours",
            moon = 79
        ),
        Planets(
            planetName = "Saturn",
            icon = R.drawable.ic_planet_saturn,
            surfaceTemperature = "-139 °C",
            discovery = "Known to the ancient Greeks and visible to the naked eye",
            originOfName = "Named for Roman god of agriculture",
            diameter = "74,900 miles (120,500 km)",
            orbit = "29.5 Earth years",
            days = "About 10.5 Earth hours",
            moon = 82
        ),
        Planets(
            planetName = "Uranus",
            icon = R.drawable.ic_planet_uranus,
            surfaceTemperature = "-197 °C",
            discovery = "1781 by William Herschel (was originally thought to be a star)",
            originOfName = "Named for the personification of heaven in ancient myth",
            diameter = " 31,763 miles (51,120 km)",
            orbit = "84 Earth years",
            days = "18 Earth hours",
            moon = 27
        ),
        Planets(
            planetName = "Neptune",
            icon = R.drawable.ic_planet_neptune,
            surfaceTemperature = "-201 °C",
            discovery = "1846",
            originOfName = "Named for the Roman god of water",
            diameter = "30,775 miles (49,530 km)",
            orbit = "165 Earth years",
            days = "19 Earth hours",
            moon = 14
        )
    )

  /*  val planet = listOf(
        Planet(
            days = "58.6 Earth days",
            diameter = "3,031 miles (4,878 km)",
            discovery = "Known to the ancient Greeks and visible to the naked eye",
            distanceFromSun = "57.91 million km",
            id = 1,
            moon = 0,
            orbit = "88 Earth days",
            originOfName = "Named for the messenger of the Roman gods",
            planetImage = R.drawable.saturn,
            planetName = "Mercury",
            position = 1,
            planetSummary = "This is the 1st, smallest, and hottest planet in the solar system. It is the nearest to the sun having an average distance of 58 km. Mercury is very close to the sun, this is why it has a very high temperature. Because of its proximity to the sun, metals like zinc or lead dissolve into vapor at such temperatures. Mercury has no satellite of its own, no atmosphere, no cloud, rain, wind, or water and hence life is non-existent on this planet. It has innumerable hills and plain land, cliffs, and valleys just like Earth and the surface of Mercury is covered with craters.",
            surfaceTemperature = "-173 - 427 °C",
        ),
        Planet(
            id = 2,
            planetName = "Venus",
            planetImage = R.drawable.venus,
            surfaceTemperature = "462 °C",
            discovery = "Known to the ancient Greeks and visible to the naked eye",
            originOfName = "Named for the Roman goddess of love and beauty",
            diameter = "7,521 miles (12,104 km)",
            orbit = "225 Earth days",
            days = "241 Earth days",
            moon = 0,
            planetSummary = "It is the second closest planet to the sun and the closest to the earth. Venus contains no living things because it is the hottest in the solar system. However, it is similar to Earth in terms of size, weight, and density, hence it is termed the Earth’s twin. Venus planet has no satellite of its own but glows in the sky like a star which makes the majority of people refer to it as a star.",
            distanceFromSun = "108.2 million km",
            position = 2
        ),
        Planet(
            id = 3,
            planetName = "Earth",
            planetImage = R.drawable.earth,
            surfaceTemperature = "-88 - 58 °C",
            discovery = "Earth was never discovered because it was never an unrecognised entity by humans.",
            originOfName = "The name Earth is a German word \"Die Erde\" which simply means ground",
            diameter = "7,926 miles (12,760 km)",
            orbit = "365.24 days",
            days = "23 hours, 56 minutes",
            moon = 1,
            planetSummary = "Being the single natural satellite of the earth, the moon revolves around the earth once every 27days. However, the distance of the Earth from the moon is 384,629 km. The earth is the only planet in whose atmosphere there is the existence of required oxygen, nitrogen, carbon dioxide, and temperature that is necessary for the survival of humans, plants, and animals. Hence, the earth is considered the most important planet in the solar system.",
            distanceFromSun = "147.87 million km",
            position = 3
        )
    )*/

    val singlePlanet = Planets(
        planetName = "Saturn",
        icon = R.drawable.ic_planet_saturn,
        surfaceTemperature = "-139 °C",
        discovery = "Known to the ancient Greeks and visible to the naked eye",
        originOfName = "Named for Roman god of agriculture",
        diameter = "74,900 miles (120,500 km)",
        orbit = "29.5 Earth years",
        days = "About 10.5 Earth hours",
        moon = 82
    )
}
