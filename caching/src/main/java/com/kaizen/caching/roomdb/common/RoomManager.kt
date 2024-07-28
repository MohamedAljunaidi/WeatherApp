package com.kaizen.caching.roomdb.common

import com.kaizen.caching.manager.BaseManager
import com.kaizen.caching.roomdb.features.favourite.entities.SearchWeatherEntity
import com.kaizen.caching.roomdb.features.home.entities.WeatherEntity
import com.kaizen.caching.util.safeLocalDataCall
import com.kaizen.core.bases.ResultWrapper
import javax.inject.Inject

class RoomManager @Inject constructor(private val databaseRoom: DatabaseRoom) : BaseManager {

    override suspend fun insertFavourite(searchWeatherEntity: SearchWeatherEntity): ResultWrapper<Unit> =
        safeLocalDataCall { databaseRoom.favouriteDao().insert(searchWeatherEntity) }

    override suspend fun insertWeather(weatherEntity: WeatherEntity): ResultWrapper<Unit> =
        safeLocalDataCall { databaseRoom.weatherDao().insert(weatherEntity) }

    override suspend fun getWeather() =
        safeLocalDataCall { databaseRoom.weatherDao().getWeather() }

    override suspend fun getFavourites() =
        safeLocalDataCall { databaseRoom.favouriteDao().getFavourite() }
    }
