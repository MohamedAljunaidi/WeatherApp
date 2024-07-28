package com.kaizen.network.extensions

import com.kaizen.core.bases.ResultWrapper
import com.kaizen.network.result.NetworkResult

inline fun <DATA, DOMAIN> tryRequest(
    request: () -> NetworkResult<DATA>,
    dataToDomain: (DATA?) -> DOMAIN
) = try {
    when (val response = request()) {
        is NetworkResult.Success -> {
            ResultWrapper.Success(dataToDomain(response.data))
        }
        is NetworkResult.Error -> {
            ResultWrapper.Error(response.error)
        }
    }
} catch (e: Exception) {
    ResultWrapper.Error(e.parseErrorResponse())
}