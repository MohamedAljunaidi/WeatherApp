package com.kaizen.caching.roomdb.features.favourite.dao

import androidx.room.Dao
import androidx.room.Query
import com.kaizen.caching.roomdb.common.BaseDao
import com.kaizen.caching.roomdb.features.favourite.entities.SearchWeatherEntity
import com.kaizen.caching.roomdb.features.home.entities.WeatherEntity

@Dao
interface FavouriteDao : BaseDao<SearchWeatherEntity> {

    @Query("SELECT * FROM SearchWeatherEntity")
    fun getFavourite(): List<SearchWeatherEntity>
}
