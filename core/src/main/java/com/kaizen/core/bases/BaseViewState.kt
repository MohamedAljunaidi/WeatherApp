package com.kaizen.core.bases

sealed class BaseViewState  {

    /**
     * Idle
     */
    object Idle : BaseViewState()

    /**
     * Loading
     */
    object Loading : BaseViewState()

    /**
     * Error when loading data.
     */
    data class Error(val resultException: ResultException) : BaseViewState()

    /**
     * Data successfully loaded.
     */
    object DataLoaded : BaseViewState()

}
