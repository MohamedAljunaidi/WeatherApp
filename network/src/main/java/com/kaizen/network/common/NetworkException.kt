package com.kaizen.network.common

import com.kaizen.core.bases.ResultException
import com.kaizen.network.R

open class NetworkException(
    messageResource: Int = R.string.error_unexpected,
    cause: Throwable? = null
) : ResultException(messageResource, cause)