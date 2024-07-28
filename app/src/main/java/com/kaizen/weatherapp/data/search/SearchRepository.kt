package com.kaizen.weatherapp.data.search

import com.kaizen.core.bases.ResultWrapper
import com.kaizen.network.extensions.tryRequest
import com.kaizen.weatherapp.data.WeatherService
import com.kaizen.weatherapp.data.toSearchWeatherList
import com.kaizen.weatherapp.data.toWeather
import com.kaizen.weatherapp.domain.home.model.Weather
import com.kaizen.weatherapp.domain.home.repository.IWeatherRepository
import com.kaizen.weatherapp.domain.search.model.SearchWeather
import com.kaizen.weatherapp.domain.search.repository.ISearchRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SearchRepository(private val weatherService: WeatherService) : ISearchRepository {

    override fun searchWeather(query: String): Flow<ResultWrapper<List<SearchWeather>?>> = flow {

        val result = tryRequest(
            request = {
                weatherService.getWeather(query)
            },
            dataToDomain = { response ->
                response?.toSearchWeatherList()
            }
        )
        emit(result)
    }
}