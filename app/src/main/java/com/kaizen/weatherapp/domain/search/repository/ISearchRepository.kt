package com.kaizen.weatherapp.domain.search.repository

import com.kaizen.core.bases.ResultWrapper
import com.kaizen.weatherapp.domain.home.model.Weather
import com.kaizen.weatherapp.domain.search.model.SearchWeather
import kotlinx.coroutines.flow.Flow

interface ISearchRepository {
    fun searchWeather(query:String): Flow<ResultWrapper<List<SearchWeather>?>>
}