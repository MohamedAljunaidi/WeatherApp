package com.kaizen.weatherapp.di

import com.kaizen.caching.manager.CachingManager
import com.kaizen.weatherapp.data.favourite.repository.FavouriteLocalRepository
import com.kaizen.weatherapp.domain.favourite.repository.IFavouriteLocalRepository
import com.kaizen.weatherapp.domain.favourite.usecases.GetFavouriteLocalUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UsecaseModule {

    @Provides
    @Singleton
    @Named("FavouriteRepository")
    fun provideFavouriteLocalRepository(cachingManager: CachingManager): IFavouriteLocalRepository {
        return FavouriteLocalRepository(cachingManager)
    }

    @Provides
    @Singleton
    @Named("FavouriteUseCase")
    fun provideGetFavouriteLocalUseCase(
        @Named("FavouriteRepository") favouriteLocalRepository: IFavouriteLocalRepository
    ): GetFavouriteLocalUseCase {
        return GetFavouriteLocalUseCase(favouriteLocalRepository)
    }


}