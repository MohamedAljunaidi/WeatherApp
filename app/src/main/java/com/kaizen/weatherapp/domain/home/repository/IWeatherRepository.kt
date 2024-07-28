package com.kaizen.weatherapp.domain.home.repository

import com.kaizen.core.bases.ResultWrapper
import com.kaizen.weatherapp.domain.home.model.Weather
import kotlinx.coroutines.flow.Flow

interface IWeatherRepository {
    fun getWeather(query:String): Flow<ResultWrapper<Weather?>>
}