package com.kaizen.weatherapp.domain.search.model


import androidx.annotation.Keep

@Keep
data class SearchWeather(
    var currentWeatherAverage: String,
    var currentDateTime: String,
    var currentWeatherIcon: String,
    var currentWeatherDesc: String,
    var currentWeatherCloudy: String,
    var currentWeatherHumidity: String,
    var currentWeatherVisibility: String,
    var city: String,
    var latitude: String,
    var longitude: String,
)