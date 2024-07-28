package com.kaizen.caching.roomdb.common

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kaizen.caching.roomdb.features.favourite.dao.FavouriteDao
import com.kaizen.caching.roomdb.features.favourite.entities.SearchWeatherEntity
import com.kaizen.caching.roomdb.features.home.dao.WeatherDao
import com.kaizen.caching.roomdb.features.home.entities.WeatherEntity

@Database(
    entities = [WeatherEntity::class,SearchWeatherEntity::class],
    version = RoomConstants.DATABASE_VERSION
)
abstract class DatabaseRoom : RoomDatabase() {

    abstract fun weatherDao(): WeatherDao
    abstract fun favouriteDao(): FavouriteDao
}
