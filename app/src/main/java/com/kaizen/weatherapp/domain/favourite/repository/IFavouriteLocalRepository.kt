package com.kaizen.weatherapp.domain.favourite.repository

import com.kaizen.core.bases.ResultWrapper
import com.kaizen.weatherapp.domain.search.model.SearchWeather
import kotlinx.coroutines.flow.Flow

interface IFavouriteLocalRepository {
    fun addToFavourite(searchWeather: SearchWeather?): Flow<ResultWrapper<Unit?>>
    fun getFavourite(): Flow<ResultWrapper<List<SearchWeather>?>>
}