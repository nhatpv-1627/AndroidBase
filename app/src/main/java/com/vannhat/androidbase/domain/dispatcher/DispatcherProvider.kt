package com.vannhat.androidbase.domain.dispatcher

import kotlin.coroutines.CoroutineContext

interface DispatcherProvider {
    fun dispatcher(): CoroutineContext
}
