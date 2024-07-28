package com.kaizen.weatherapp.presentation.search

import com.kaizen.core.bases.BaseViewModel
import com.kaizen.core.bases.BaseViewState
import com.kaizen.core.bases.ResultWrapper
import com.kaizen.weatherapp.domain.search.model.SearchWeather
import com.kaizen.weatherapp.domain.favourite.usecases.AddToFavouriteUseCase
import com.kaizen.weatherapp.domain.search.usecases.SearchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchUseCase: SearchUseCase,
    private val addToFavouriteUseCase: AddToFavouriteUseCase
) : BaseViewModel() {

    private var _searchSuccess: MutableSharedFlow<List<SearchWeather>?> =
        MutableSharedFlow(replay = 1)

    val searchSuccess: SharedFlow<List<SearchWeather>?> =
        _searchSuccess.asSharedFlow()

    private var _addToFavouriteSuccess: MutableSharedFlow<Boolean?> =
        MutableSharedFlow(replay = 0)

    val addToFavouriteSuccess: SharedFlow<Boolean?> =
        _addToFavouriteSuccess.asSharedFlow()

    fun searchWeather(countryName: String) {
        launchCoroutine(coroutineExceptionHandler) {
            searchUseCase(countryName)
                .onStart {
                    _state.emit(BaseViewState.Loading)
                }
                .onCompletion {
                    _state.emit(BaseViewState.DataLoaded)
                }
                .collectLatest { result ->
                    when (result) {
                        is ResultWrapper.Success -> {

                            _searchSuccess.emit(result.data)
                        }

                        is ResultWrapper.Error -> {
                            _state.emit(
                                BaseViewState.Error(
                                    result.error
                                )
                            )
                        }

                    }
                }
        }
    }

    fun addToFavourite(searchWeather: SearchWeather) {

        launchCoroutine(coroutineExceptionHandler) {
            addToFavouriteUseCase(searchWeather)
                .onStart {
                    _state.emit(BaseViewState.Loading)
                }
                .onCompletion {
                    _state.emit(BaseViewState.DataLoaded)
                }
                .collectLatest { result ->
                    when (result) {
                        is ResultWrapper.Success -> {
                            _addToFavouriteSuccess.emit(true)
                        }

                        is ResultWrapper.Error -> {
                            _state.emit(
                                BaseViewState.Error(
                                    result.error
                                )
                            )
                        }

                    }
                }
        }
    }

}