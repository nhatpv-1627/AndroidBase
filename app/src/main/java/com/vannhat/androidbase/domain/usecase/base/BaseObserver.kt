package com.vannhat.androidbase.domain.usecase.base

import kotlin.coroutines.cancellation.CancellationException

open class BaseObserver<Output> {
    private var onSubscribe: (() -> Unit)? = null
    private var onSuccess: ((Output) -> Unit)? = null
    private var onError: ((Throwable) -> Unit)? = null
    private var onCancel: ((CancellationException) -> Unit)? = null

    fun onSubscribe(block: () -> Unit) {
        onSubscribe = block
    }

    fun onSuccess(block: (Output) -> Unit) {
        onSuccess = block
    }

    fun onError(block: (Throwable) -> Unit) {
        onError = block
    }

    fun onCancel(block: (CancellationException) -> Unit) {
        onCancel = block
    }

    operator fun invoke() = onSubscribe?.invoke()
    operator fun invoke(output: Output) = onSuccess?.invoke(output)
    operator fun invoke(throwable: Throwable) = onError?.invoke(throwable)
    operator fun invoke(cancellationException: CancellationException) =
        onCancel?.invoke(cancellationException)
}
