package com.kaizen.core.bases

open class ResultException(
    val messageResource: Int? = null,
    cause: Throwable? = null
): RuntimeException(cause)