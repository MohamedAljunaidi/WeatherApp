package com.kaizen.weatherapp.data.home.repository

import com.kaizen.caching.manager.CachingManager
import com.kaizen.caching.manager.ProviderEnum
import com.kaizen.caching.util.tryMapperQuery
import com.kaizen.core.bases.ResultWrapper
import com.kaizen.weatherapp.data.toWeather
import com.kaizen.weatherapp.data.toWeatherEntity
import com.kaizen.weatherapp.domain.home.model.Weather
import com.kaizen.weatherapp.domain.home.repository.IWeatherLocalRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class WeatherLocalRepository(private val cachingManager: CachingManager) :
    IWeatherLocalRepository {

    override fun getWeather(): Flow<ResultWrapper<Weather?>> = flow {
        val result = tryMapperQuery({
            cachingManager.getProvider(ProviderEnum.ROOM).getWeather()
        })
        { weather ->
            weather?.toWeather()
        }
        emit(result)
    }


    override fun insertWeather(weather: Weather?): Flow<ResultWrapper<Unit?>> =
        flow {
            val result = tryMapperQuery({
                weather?.toWeatherEntity()?.let {
                    cachingManager.getProvider(ProviderEnum.ROOM)
                        .insertWeather(it)
                }
            }) {}
            emit(result)
        }


}
