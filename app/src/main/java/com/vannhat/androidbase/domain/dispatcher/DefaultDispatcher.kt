package com.vannhat.androidbase.domain.dispatcher

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

class DefaultDispatcher : DispatcherProvider {
    override fun dispatcher(): CoroutineContext {
        return Dispatchers.Default
    }
}
