package com.kaizen.network.di

import com.kaizen.network.common.NetworkFactory
import com.kaizen.network.services.ApiManager
import com.kaizen.network.services.ApiRequests
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideApiDao(
        retrofit: Retrofit
    ): ApiRequests {
        return NetworkFactory.create(retrofit)
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(
        ): OkHttpClient {
        return NetworkFactory.getOkHttpClient()
    }

    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit {
        return NetworkFactory.getRetrofit(okHttpClient)
    }

    @Singleton
    @Provides
    fun provideApiManager(
        services: ApiRequests
    ): ApiManager {
        return ApiManager(services)
    }
}