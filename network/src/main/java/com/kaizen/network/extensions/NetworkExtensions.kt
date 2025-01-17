package com.kaizen.network.extensions

import com.kaizen.network.common.NetworkException
import com.kaizen.network.result.NetworkResult
import retrofit2.HttpException
import retrofit2.Response

inline fun <T> safeApiCall(
    apiCall: () -> Response<T>
): NetworkResult<Response<T>> {
    return runCatching {
        val response = apiCall()
        if (! response.isSuccessful) {
            throw HttpException(response)
        }
        response
    }.toNetworkResult()
}

inline fun <T, R> NetworkResult<T>.map(
    mapper: (T?) -> R?
): NetworkResult<R> {
    return when (this) {
        is NetworkResult.Success -> {
            runCatching {
                mapper(data)
            }.toNetworkResult()
        }
        is NetworkResult.Error -> {
            NetworkResult.Error(error)
        }
    }
}

fun <T> Result<T?>.toNetworkResult(): NetworkResult<T> = fold(
    onSuccess = { result ->
        NetworkResult.Success(result)
    },
    onFailure = { error ->
        val errorModel = error.parseErrorResponse()
        NetworkResult.Error(errorModel)
    }
)

fun Throwable.parseErrorResponse() = mapApiError(this)

private fun mapApiError(error: Throwable): NetworkException =
    NetworkException(cause = error)

