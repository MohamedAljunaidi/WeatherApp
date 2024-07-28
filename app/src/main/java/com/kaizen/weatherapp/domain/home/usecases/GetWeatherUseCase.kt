package com.kaizen.weatherapp.domain.home.usecases

import com.kaizen.core.bases.BaseUseCase
import com.kaizen.core.bases.ResultWrapper
import com.kaizen.core.extensions.networkBoundResource
import com.kaizen.core.extensions.resultWrapperData
import com.kaizen.weatherapp.domain.home.model.Weather
import com.kaizen.weatherapp.domain.home.repository.IWeatherLocalRepository
import com.kaizen.weatherapp.domain.home.repository.IWeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject
import kotlinx.coroutines.flow.collect

class GetWeatherUseCase @Inject constructor(
    private val remoteRepository: IWeatherRepository,
    private val localRepository: IWeatherLocalRepository
) : BaseUseCase<String, Flow<ResultWrapper<Weather?>>> {

    private var response: Flow<ResultWrapper<Weather?>> = emptyFlow()

    override suspend fun invoke(params: String?): Flow<ResultWrapper<Weather?>> =
        networkBoundResource(
            queryDb = {
                localRepository.getWeather()
            },
            fetchApi = {
                remoteRepository.getWeather(query = params ?: "")
            },
            saveApiResult = { fetchResult ->
                fetchResult.collect { resultWrapper ->
                    this.response = flowOf(resultWrapper)

                    resultWrapperData(resultWrapper, { weather ->
                        localRepository.insertWeather(
                            weather = weather
                        ).collect()
                    }, {
                        localRepository.getWeather()
                    })
                }
            }, onQueryDbError = {
                response
            }
        )
}

