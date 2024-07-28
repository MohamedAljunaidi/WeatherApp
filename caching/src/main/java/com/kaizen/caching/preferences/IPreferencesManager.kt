package com.kaizen.caching.preferences

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

interface IPreferencesManager {


    suspend fun setLoggedInUserEmail(value: String?){}
    fun getLoggedInUserEmail(): Flow<String?>{
        return emptyFlow()
    }

}