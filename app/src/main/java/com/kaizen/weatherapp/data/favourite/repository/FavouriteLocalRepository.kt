package com.kaizen.weatherapp.data.favourite.repository

import com.kaizen.caching.manager.CachingManager
import com.kaizen.caching.manager.ProviderEnum
import com.kaizen.caching.util.tryMapperQuery
import com.kaizen.core.bases.ResultWrapper
import com.kaizen.weatherapp.data.toSearchWeather
import com.kaizen.weatherapp.data.toSearchWeatherEntity
import com.kaizen.weatherapp.domain.search.model.SearchWeather
import com.kaizen.weatherapp.domain.favourite.repository.IFavouriteLocalRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FavouriteLocalRepository(private val cachingManager: CachingManager) :
    IFavouriteLocalRepository {

    override fun getFavourite(): Flow<ResultWrapper<List<SearchWeather>?>> = flow {
        val result = tryMapperQuery({
            cachingManager.getProvider(ProviderEnum.ROOM).getFavourites()
        })
        { weather ->
            weather?.toSearchWeather()
        }
        emit(result)
    }


    override fun addToFavourite(searchWeather: SearchWeather?): Flow<ResultWrapper<Unit?>> =
        flow {
            val result = tryMapperQuery({
                searchWeather?.toSearchWeatherEntity()?.let {
                    cachingManager.getProvider(ProviderEnum.ROOM)
                        .insertFavourite(it)
                }
            }) {}
            emit(result)
        }


}
