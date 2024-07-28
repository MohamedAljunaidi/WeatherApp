package com.kaizen.network.services

import com.kaizen.network.extensions.getModel
import com.kaizen.network.extensions.map
import com.kaizen.network.extensions.safeApiCall
import com.kaizen.network.result.NetworkResult
import javax.inject.Inject

class ApiManager @Inject constructor(
    val services: ApiRequests,
) {

    suspend inline fun <reified T> getRequest(
        url: String,
        headersMap: Map<String, String>? = mapOf(),
        queryParamsMap: Map<String, Any?>? = mapOf()
    ): NetworkResult<T> =
        safeApiCall {
            services.getRequest(
                url = url,
                headersMap = headersMap,
                queryParamsMap = queryParamsMap
            )
        }.map { response ->
                response?.body()?.getModel()
            }
}