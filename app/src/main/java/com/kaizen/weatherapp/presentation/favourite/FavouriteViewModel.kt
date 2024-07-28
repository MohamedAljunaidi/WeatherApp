package com.kaizen.weatherapp.presentation.favourite

import com.kaizen.core.bases.BaseViewModel
import com.kaizen.core.bases.BaseViewState
import com.kaizen.core.bases.ResultWrapper
import com.kaizen.weatherapp.domain.favourite.usecases.GetFavouriteLocalUseCase
import com.kaizen.weatherapp.domain.search.model.SearchWeather
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

@HiltViewModel
class FavouriteViewModel @Inject constructor(
    private val getFavouriteLocalUseCase: GetFavouriteLocalUseCase
) :  BaseViewModel(){

    private var _favouritesSuccess: MutableSharedFlow<List<SearchWeather>?> =
        MutableSharedFlow(replay = 1)

    val favouritesSuccess: SharedFlow<List<SearchWeather>?> =
        _favouritesSuccess.asSharedFlow()

    fun getFavourites() {

        launchCoroutine(coroutineExceptionHandler) {
            getFavouriteLocalUseCase()
                .onStart {
                    _state.emit(BaseViewState.Loading)
                }
                .onCompletion {
                    _state.emit(BaseViewState.DataLoaded)
                }
                .collectLatest { result ->
                    when (result) {
                        is ResultWrapper.Success -> {

                            _favouritesSuccess.emit(result.data)
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