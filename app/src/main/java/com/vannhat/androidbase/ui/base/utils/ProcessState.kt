package com.vannhat.androidbase.ui.base.utils

/**
 * Use this class when we want to handle loading, error separately
 */
data class ProcessState<T>(
    private val status: Status,
    val data: T? = null,
    val throwable: Throwable? = null
) {

    companion object {
        fun <T> success(data: T? = null): ProcessState<T> {
            return ProcessState(
                SuccessStatus,
                data
            )
        }

        fun <T> error(throwable: Throwable?): ProcessState<T> {
            return ProcessState(
                ErrorStatus,
                throwable = throwable
            )
        }

        fun <T> loading(): ProcessState<T> {
            return ProcessState(LoadingStatus)
        }
    }

    fun isLoading() = status is LoadingStatus
    fun isError() = status is ErrorStatus
    fun isSuccess() = status is SuccessStatus
}

sealed class Status
object LoadingStatus : Status()
object SuccessStatus : Status()
object ErrorStatus : Status()
