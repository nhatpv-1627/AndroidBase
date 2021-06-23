package com.vannhat.androidbase.ui.base

import androidx.lifecycle.ViewModel
import com.vannhat.androidbase.ui.base.utils.SingleLiveEvent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

open class BaseViewModel : ViewModel() {

    protected val eventChannel = Channel<Event>(Channel.BUFFERED)
    val eventsFlow = eventChannel.receiveAsFlow()

    sealed class Event {
        data class OnError(val exception: Exception) : Event()
        data class OnLoading(var isShowing: Boolean) : Event()
    }

}
