package com.kaizen.caching.roomdb.features.home.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.kaizen.caching.roomdb.features.home.HourListConverter
import com.kaizen.caching.roomdb.features.home.WeekWeatherListConverter


@Entity(tableName = "WeatherEntity")
data class WeatherEntity(

    @SerializedName("id")
    @PrimaryKey
    var id: Int = 1,

    @SerializedName("currentWeatherAverage")
    var currentWeatherAverage: String? = null,

    @SerializedName("currentDateTime")
    var currentDateTime: String? = null,

    @SerializedName("currentWeatherIcon")
    var currentWeatherIcon: String? = null,
    @SerializedName("currentWeatherDesc")
    var currentWeatherDesc: String? = null,
    @SerializedName("currentWeatherCloudy")
    var currentWeatherCloudy: String? = null,
    @SerializedName("currentWeatherHumidity")
    var currentWeatherHumidity: String? = null,
    @SerializedName("currentWeatherHumidity")
    var city: String? = null,

    @SerializedName("currentWeatherVisibility")
    var currentWeatherVisibility: String? = null,

    @SerializedName("hourly")
    @field:TypeConverters(HourListConverter::class) var hourly: List<Hourly>? = null,

    @SerializedName("weekWeather")
    @field:TypeConverters(WeekWeatherListConverter::class) var weekWeather: List<WeekWeather>? = null,

    ) {

    data class Hourly(
        @SerializedName("weatherAverage")
        var weatherAverage: String? = null,
        @SerializedName("weatherIcon")
        var weatherIcon: String? = null,
        @SerializedName("time")
        var time: String? = null,
    )

    data class WeekWeather(
        @SerializedName("weatherAverage")
        var weatherAverage: String? = null,

        @SerializedName("weatherIcon")
        var weatherIcon: String? = null,

        @SerializedName("date")
        var date: String? = null,
    )

}