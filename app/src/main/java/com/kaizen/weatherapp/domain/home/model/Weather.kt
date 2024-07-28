package com.kaizen.weatherapp.domain.home.model


data class Weather(
    var currentWeatherAverage: String,
    var currentDateTime: String,
    var currentWeatherIcon: String,
    var currentWeatherDesc: String,
    var currentWeatherCloudy: String,
    var currentWeatherHumidity: String,
    var currentWeatherVisibility: String,
    var city: String,
    var hourly: List<Hourly>? = listOf(),
    var weekWeather: List<WeekWeather>? = listOf(),

    ) {

    data class Hourly(
        var weatherAverage: String,
        var weatherIcon: String,
        var time: String,
    )

    data class WeekWeather(
        var weatherAverage: String,
        var weatherIcon: String,
        var date: String,
    )

}