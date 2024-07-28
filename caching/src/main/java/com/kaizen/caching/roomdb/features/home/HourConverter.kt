package com.kaizen.caching.roomdb.features.home

import com.kaizen.caching.roomdb.common.converter.ListConverter
import com.kaizen.caching.roomdb.features.home.entities.WeatherEntity
import com.kaizen.caching.util.type


class HourListConverter :
    ListConverter<WeatherEntity.Hourly>(type<List<WeatherEntity.Hourly>>())

class WeekWeatherListConverter :
    ListConverter<WeatherEntity.WeekWeather>(type<List<WeatherEntity.WeekWeather>>())

