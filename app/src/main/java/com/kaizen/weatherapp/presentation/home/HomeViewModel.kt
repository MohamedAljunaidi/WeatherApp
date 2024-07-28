package com.kaizen.weatherapp.presentation.home

import com.kaizen.core.bases.BaseViewModel
import com.kaizen.core.bases.BaseViewState
import com.kaizen.core.bases.ResultWrapper
import com.kaizen.weatherapp.domain.home.model.Weather
import com.kaizen.weatherapp.domain.home.usecases.GetWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getWeatherUseCase: GetWeatherUseCase
) :  BaseViewModel(){

    private var _weatherSuccess: MutableSharedFlow<Weather?> =
        MutableSharedFlow(replay = 1)

    val weatherSuccess: SharedFlow<Weather?> =
        _weatherSuccess.asSharedFlow()


    fun getWeatherService(lat: String, long: String) {

        launchCoroutine(coroutineExceptionHandler) {
            getWeatherUseCase("$lat,$long")
                .onStart {
                    _state.emit(BaseViewState.Loading)
                }
                .onCompletion {
                    _state.emit(BaseViewState.DataLoaded)
                }
                .collectLatest { result ->
                    when (result) {
                        is ResultWrapper.Success -> {

                            _weatherSuccess.emit(result.data)
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