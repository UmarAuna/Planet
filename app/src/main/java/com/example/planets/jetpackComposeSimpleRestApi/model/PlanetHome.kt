package com.example.planets.jetpackComposeSimpleRestApi.model

import android.os.Parcelable
import androidx.annotation.Keep
import androidx.lifecycle.LiveData
import androidx.room.*
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
@Entity(tableName = "PlanetHome")
data class PlanetHome(

    @SerializedName("days")
    val days: String? = null,
    @SerializedName("diameter")
    val diameter: String? = null,
    @SerializedName("discovery")
    val discovery: String? = null,
    @SerializedName("distanceFromSun")
    val distanceFromSun: String? = null,
    @PrimaryKey
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

@Dao
interface PlanetHomeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(items: List<PlanetHome>)

    @Query("DELETE FROM PlanetHome")
    fun deleteAll()

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(items: List<PlanetHome>)

    @Query("SELECT * FROM PlanetHome ORDER BY id DESC")
    fun getAll(): LiveData<List<PlanetHome>>

    @Delete
    fun delete(items: PlanetHome)
}
