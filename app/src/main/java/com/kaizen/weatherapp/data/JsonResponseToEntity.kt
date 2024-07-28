package com.kaizen.weatherapp.data

import com.kaizen.caching.roomdb.features.favourite.entities.SearchWeatherEntity
import com.kaizen.caching.roomdb.features.home.entities.WeatherEntity
import com.kaizen.weatherapp.data.home.model.WeatherResponse
import com.kaizen.weatherapp.domain.home.model.Weather
import com.kaizen.weatherapp.domain.search.model.SearchWeather


internal fun WeatherEntity.toWeather(): Weather {

    return Weather(
        currentWeatherAverage = currentWeatherAverage ?: "",
        currentDateTime = currentDateTime ?: "",
        currentWeatherIcon = currentWeatherIcon ?: "",
        currentWeatherDesc = currentWeatherDesc ?: "",
        currentWeatherCloudy = currentWeatherCloudy ?: "",
        currentWeatherHumidity = currentWeatherHumidity ?: "",
        city = city ?: "",
        currentWeatherVisibility = currentWeatherVisibility ?: "",
        hourly = hourly?.map { hourly ->
            Weather.Hourly(
                weatherAverage = hourly.weatherAverage ?: "",
                weatherIcon = hourly.weatherIcon ?: "",
                time = hourly.time ?: ""
            )
        },
        weekWeather = weekWeather?.map { weekWeather ->
            Weather.WeekWeather(
                weatherAverage = weekWeather.weatherAverage ?: "",
                weatherIcon = weekWeather.weatherIcon ?: "",
                date = weekWeather.date ?: ""
            )
        }
    )
}

internal fun Weather.toWeatherEntity(): WeatherEntity {

    return WeatherEntity(
        currentWeatherAverage = currentWeatherAverage,
        currentDateTime = currentDateTime,
        currentWeatherIcon = currentWeatherIcon,
        currentWeatherDesc = currentWeatherDesc,
        currentWeatherCloudy = currentWeatherCloudy,
        currentWeatherHumidity = currentWeatherHumidity,
        currentWeatherVisibility = currentWeatherVisibility,
        city = city,
        hourly = hourly?.map { hourly ->
            WeatherEntity.Hourly(
                weatherAverage = hourly.weatherAverage,
                weatherIcon = hourly.weatherIcon,
                time = hourly.time
            )
        },
        weekWeather = weekWeather?.map { weekWeather ->
            WeatherEntity.WeekWeather(
                weatherAverage = weekWeather.weatherAverage,
                weatherIcon = weekWeather.weatherIcon,
                date = weekWeather.date
            )
        }

    )
}

internal fun SearchWeather.toSearchWeatherEntity(): SearchWeatherEntity {


    return SearchWeatherEntity(
        currentWeatherAverage = currentWeatherAverage,
        currentDateTime = currentDateTime,
        currentWeatherIcon = currentWeatherIcon,
        currentWeatherDesc = currentWeatherDesc,
        currentWeatherCloudy = currentWeatherCloudy,
        currentWeatherHumidity = currentWeatherHumidity,
        currentWeatherVisibility = currentWeatherVisibility,
        city = city,
        latitude = latitude,
        longitude = longitude
    )


}

internal fun List<SearchWeatherEntity>.toSearchWeather(): List<SearchWeather> {
    val searchList = arrayListOf<SearchWeather>()

    this.forEach {
        searchList.add(
            SearchWeather(
                currentWeatherAverage = it.currentWeatherAverage,
                currentDateTime = it.currentDateTime,
                currentWeatherIcon = it.currentWeatherIcon,
                currentWeatherDesc = it.currentWeatherDesc,
                currentWeatherCloudy = it.currentWeatherCloudy,
                currentWeatherHumidity = it.currentWeatherHumidity,
                currentWeatherVisibility = it.currentWeatherVisibility,
                city = it.city,
                latitude = it.latitude,
                longitude = it.longitude
            )
        )
    }

    return searchList
}