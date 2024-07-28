package com.kaizen.caching.roomdb.features.home.dao

import androidx.room.Dao
import androidx.room.Query
import com.kaizen.caching.roomdb.common.BaseDao
import com.kaizen.caching.roomdb.features.home.entities.WeatherEntity

@Dao
interface WeatherDao : BaseDao<WeatherEntity> {

    @Query("SELECT * FROM WeatherEntity")
    fun getWeather(): WeatherEntity
}
