package com.kaizen.weatherapp.domain.home.repository

import com.kaizen.core.bases.ResultWrapper
import com.kaizen.weatherapp.domain.home.model.Weather
import kotlinx.coroutines.flow.Flow

interface IWeatherLocalRepository {

    fun getWeather(): Flow<ResultWrapper<Weather?>>
    fun insertWeather(weather: Weather?): Flow<ResultWrapper<Unit?>>
}