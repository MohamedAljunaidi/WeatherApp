package com.kaizen.caching.di

import android.content.Context
import com.kaizen.caching.manager.CachingManager
import com.kaizen.caching.preferences.datastore.PreferencesDataStoreManager
import com.kaizen.caching.roomdb.common.DatabaseRoom
import com.kaizen.caching.roomdb.common.RoomClient
import com.kaizen.caching.roomdb.common.RoomManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CachingModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): DatabaseRoom {
        return RoomClient.createDatabaseRoom(appContext)
    }

    @Provides
    @Singleton
    fun provideCachingManager(
        preferencesDataStoreManager: PreferencesDataStoreManager,
        roomManager: RoomManager
    ): CachingManager {
        return CachingManager(preferencesDataStoreManager, roomManager)
    }
}