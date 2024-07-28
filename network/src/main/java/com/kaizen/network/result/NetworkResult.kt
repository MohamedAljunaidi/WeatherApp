package com.kaizen.network.result

import com.kaizen.network.common.NetworkException

sealed class NetworkResult<out T> {

    data class Success<T>(val data: T?) : NetworkResult<T>()

    data class Error(val error: NetworkException) : NetworkResult<Nothing>()

}