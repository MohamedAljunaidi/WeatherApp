package com.kaizen.weatherapp.data

import com.kaizen.core.extensions.convertToReadableTime
import com.kaizen.weatherapp.data.home.model.WeatherResponse
import com.kaizen.weatherapp.domain.home.model.Weather
import com.kaizen.weatherapp.domain.home.model.Weather.Hourly
import com.kaizen.weatherapp.domain.home.model.Weather.WeekWeather
import com.kaizen.weatherapp.domain.search.model.SearchWeather

internal fun WeatherResponse.toWeather(): Weather {

    val hourlyList = arrayListOf<Hourly>()
    val weekWeatherList = arrayListOf<WeekWeather>()
    this.weatherDataResponse?.weatherItemResponse?.get(0)?.hourlyResponse
        ?.forEach { hourlyResponse ->
            hourlyList.add(
                Hourly(
                    weatherAverage = hourlyResponse?.tempC ?: "",
                    weatherIcon = hourlyResponse?.weatherIconUrlResponse?.get(0)?.value ?: "",
                    time = hourlyResponse?.time?.toInt()?.convertToReadableTime() ?: "",
                )
            )
        }

    this.weatherDataResponse?.weatherItemResponse?.forEach { weekResponse ->
        weekWeatherList.add(
            WeekWeather(
                weatherAverage = weekResponse?.avgtempC ?: "",
                weatherIcon = weekResponse?.hourlyResponse?.get(12)?.weatherIconUrlResponse?.get(0)?.value
                    ?: "",
                date = weekResponse?.date ?: "",
            )
        )
    }



    return Weather(
        currentWeatherAverage = weatherDataResponse?.currentConditionResponse?.get(0)?.tempC ?: "",
        currentDateTime = weatherDataResponse?.currentConditionResponse?.get(0)?.localObsDateTime
            ?: "",
        currentWeatherIcon = weatherDataResponse?.currentConditionResponse?.get(0)?.weatherIconUrl?.get(
            0
        )?.value ?: "",
        currentWeatherDesc = weatherDataResponse?.currentConditionResponse?.get(0)?.weatherDesc?.get(
            0
        )?.value ?: "",
        currentWeatherCloudy = weatherDataResponse?.currentConditionResponse?.get(0)?.cloudcover
            ?: "",
        currentWeatherHumidity = weatherDataResponse?.currentConditionResponse?.get(0)?.humidity
            ?: "",
        currentWeatherVisibility = weatherDataResponse?.currentConditionResponse?.get(0)?.visibility
            ?: "",
        hourly = hourlyList,
        weekWeather = weekWeatherList,
        city = weatherDataResponse?.nearestAreaResponse?.get(0)?.region?.get(0)?.value + ", " +
                weatherDataResponse?.nearestAreaResponse?.get(0)?.country?.get(0)?.value,
    )
}


internal fun WeatherResponse.toSearchWeatherList(): List<SearchWeather> {

    val searchList = arrayListOf<SearchWeather>()

    weatherDataResponse?.currentConditionResponse?.forEach {
        searchList.add(
            SearchWeather(
                currentWeatherAverage = it?.tempC ?: "",
                currentDateTime = it?.localObsDateTime ?: "",
                currentWeatherIcon = it?.weatherIconUrl?.get(0)?.value ?: "",
                currentWeatherDesc = it?.weatherDesc?.get(0)?.value ?: "",
                currentWeatherCloudy = it?.cloudcover ?: "",
                currentWeatherHumidity = it?.humidity ?: "",
                currentWeatherVisibility = it?.visibility ?: "",
                latitude = weatherDataResponse?.nearestAreaResponse?.get(0)?.latitude?:"",
                longitude = weatherDataResponse?.nearestAreaResponse?.get(0)?.longitude?:"",
                city = weatherDataResponse?.nearestAreaResponse?.get(0)?.region?.get(0)?.value + ", " +
                        weatherDataResponse?.nearestAreaResponse?.get(0)?.country?.get(0)?.value,
            )
        )
    }

    return searchList


}

