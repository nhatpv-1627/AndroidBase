package com.vannhat.androidbase.domain.dispatcher

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

class IODispatcher : DispatcherProvider {
    override fun dispatcher(): CoroutineContext {
        return Dispatchers.IO
    }
}
