package com.example.planets.model

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class Planet(
    @SerializedName("days")
    val days: String? = null,
    @SerializedName("diameter")
    val diameter: String? = null,
    @SerializedName("discovery")
    val discovery: String? = null,
    @SerializedName("distanceFromSun")
    val distanceFromSun: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("moon")
    val moon: Int? = null,
    @SerializedName("orbit")
    val orbit: String? = null,
    @SerializedName("originOfName")
    val originOfName: String? = null,
    @SerializedName("planetImage")
    val planetImage: String? = null,
    // @DrawableRes val planetImage: Int,
    @SerializedName("planetName")
    val planetName: String? = null,
    @SerializedName("planetSummary")
    val planetSummary: String? = null,
    @SerializedName("position")
    val position: Int? = null,
    @SerializedName("surfaceTemperature")
    val surfaceTemperature: String? = null,
) : Parcelable
