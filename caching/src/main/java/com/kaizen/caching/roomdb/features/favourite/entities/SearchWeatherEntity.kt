package com.kaizen.caching.roomdb.features.favourite.entities


import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Keep
@Entity(tableName = "SearchWeatherEntity")
data class SearchWeatherEntity(

    @PrimaryKey
    @SerializedName("city")
    var city: String,

    @SerializedName("currentWeatherAverage")
    var currentWeatherAverage: String,

    @SerializedName("currentDateTime")
    var currentDateTime: String,

    @SerializedName("currentWeatherIcon")
    var currentWeatherIcon: String,

    @SerializedName("currentWeatherDesc")
    var currentWeatherDesc: String,

    @SerializedName("currentWeatherCloudy")
    var currentWeatherCloudy: String,

    @SerializedName("currentWeatherHumidity")
    var currentWeatherHumidity: String,

    @SerializedName("currentWeatherVisibility")
    var currentWeatherVisibility: String,

    @SerializedName("latitude")
    var latitude: String,

    @SerializedName("longitude")
    var longitude: String,


)