package com.kaizen.weatherapp.domain.favourite.usecases

import com.kaizen.core.bases.BaseUseCase
import com.kaizen.core.bases.ResultWrapper
import com.kaizen.weatherapp.domain.search.model.SearchWeather
import com.kaizen.weatherapp.domain.favourite.repository.IFavouriteLocalRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFavouriteLocalUseCase @Inject constructor(
    private val localRepository: IFavouriteLocalRepository,
) : BaseUseCase<Unit, Flow<ResultWrapper<List<SearchWeather>?>>> {

    override suspend fun invoke(params: Unit?): Flow<ResultWrapper<List<SearchWeather>?>> =
        localRepository.getFavourite()

}

