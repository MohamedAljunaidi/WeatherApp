package com.kaizen.weatherapp.di

import com.kaizen.caching.manager.CachingManager
import com.kaizen.weatherapp.data.WeatherService
import com.kaizen.weatherapp.data.home.repository.WeatherLocalRepository
import com.kaizen.weatherapp.data.home.repository.WeatherRepository
import com.kaizen.weatherapp.data.favourite.repository.FavouriteLocalRepository
import com.kaizen.weatherapp.data.search.SearchRepository
import com.kaizen.weatherapp.domain.home.repository.IWeatherLocalRepository
import com.kaizen.weatherapp.domain.home.repository.IWeatherRepository
import com.kaizen.weatherapp.domain.favourite.repository.IFavouriteLocalRepository
import com.kaizen.weatherapp.domain.search.repository.ISearchRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class RepositoryModule {

    @Provides
    @ViewModelScoped
    fun getWeatherRepository(weatherService: WeatherService): IWeatherRepository {
        return WeatherRepository(weatherService)
    }

    @Provides
    @ViewModelScoped
    fun getWeatherLocalRepository(cachingManager: CachingManager): IWeatherLocalRepository {
        return WeatherLocalRepository(cachingManager)
    }

    @Provides
    @ViewModelScoped
    fun getSearchRepository(weatherService: WeatherService): ISearchRepository {
        return SearchRepository(weatherService)
    }

    @Provides
    @ViewModelScoped
    fun getFavouriteLocalRepository(cachingManager: CachingManager): IFavouriteLocalRepository {
        return FavouriteLocalRepository(cachingManager)
    }

}