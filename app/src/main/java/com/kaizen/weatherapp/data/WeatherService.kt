package com.kaizen.weatherapp.data

import com.kaizen.network.result.NetworkResult
import com.kaizen.network.services.ApiManager
import com.kaizen.weatherapp.BuildConfig
import com.kaizen.weatherapp.data.home.model.WeatherResponse
import javax.inject.Inject

class WeatherService @Inject constructor(private val apiManager: ApiManager) {

    companion object {

        private const val API_KEY = "key"
        private const val QUERY = "q"
        private const val FORMAT = "format"
        private const val NUMBER_OF_DAYS = "num_of_days"
        private const val EXTRA = "extra"
        private const val INCLUDE_LOCATION = "includeLocation"
        private const val TP = "tp"
        private const val PATH_EVENT_DETAILS =
            "premium/v1/weather.ashx"
    }

    suspend fun getWeather(
        query: String,
    ): NetworkResult<WeatherResponse> {
        return apiManager.getRequest(
            PATH_EVENT_DETAILS,
            queryParamsMap = mapOf(
                API_KEY to BuildConfig.API_KEY,
                QUERY to query,
                FORMAT to "json",
                NUMBER_OF_DAYS to "7",
                EXTRA to "localObsTime",
                INCLUDE_LOCATION to "yes",
                TP to "1"
            )
        )
    }
}