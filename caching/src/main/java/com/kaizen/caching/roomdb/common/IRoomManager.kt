package com.kaizen.caching.roomdb.common

import com.kaizen.caching.roomdb.features.favourite.entities.SearchWeatherEntity
import com.kaizen.caching.roomdb.features.home.entities.WeatherEntity
import com.kaizen.core.bases.ResultWrapper

interface IRoomManager {


    suspend fun insertFavourite(searchWeatherEntity: SearchWeatherEntity): ResultWrapper<Unit>? = null
    suspend fun insertWeather(weatherEntity: WeatherEntity): ResultWrapper<Unit>? = null
    suspend fun getWeather(): ResultWrapper<WeatherEntity>? = null
    suspend fun getFavourites(): ResultWrapper<List<SearchWeatherEntity>>? = null
}