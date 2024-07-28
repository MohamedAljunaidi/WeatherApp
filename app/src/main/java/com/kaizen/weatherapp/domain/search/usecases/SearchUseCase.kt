package com.kaizen.weatherapp.domain.search.usecases

import com.kaizen.core.bases.BaseUseCase
import com.kaizen.core.bases.ResultWrapper
import com.kaizen.weatherapp.domain.home.model.Weather
import com.kaizen.weatherapp.domain.home.repository.IWeatherRepository
import com.kaizen.weatherapp.domain.search.model.SearchWeather
import com.kaizen.weatherapp.domain.search.repository.ISearchRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchUseCase @Inject constructor(
    private val remoteRepository: ISearchRepository,
) : BaseUseCase<String, Flow<ResultWrapper<List<SearchWeather>?>>> {

    override suspend fun invoke(params: String?): Flow<ResultWrapper<List<SearchWeather>?>> =
        remoteRepository.searchWeather(query = params ?: "")

}

