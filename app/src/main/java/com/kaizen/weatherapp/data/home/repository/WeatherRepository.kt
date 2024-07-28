package com.kaizen.weatherapp.data.home.repository

import com.kaizen.core.bases.ResultWrapper
import com.kaizen.network.extensions.tryRequest
import com.kaizen.weatherapp.data.WeatherService
import com.kaizen.weatherapp.data.toWeather
import com.kaizen.weatherapp.domain.home.model.Weather
import com.kaizen.weatherapp.domain.home.repository.IWeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class WeatherRepository(private val weatherService: WeatherService) : IWeatherRepository {

    override fun getWeather(query: String): Flow<ResultWrapper<Weather?>> = flow {

        val result = tryRequest(
            request = {
                weatherService.getWeather(query)
            },
            dataToDomain = { response ->
                response?.toWeather()
            }
        )
        emit(result)
    }
}