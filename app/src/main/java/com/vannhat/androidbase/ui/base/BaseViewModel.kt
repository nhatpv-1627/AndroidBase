package com.vannhat.androidbase.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent
import retrofit2.HttpException
import retrofit2.Response

open class BaseViewModel : ViewModel(), KoinComponent {

    protected val eventChannel = Channel<Event>(Channel.BUFFERED)
    val eventsFlow = eventChannel.receiveAsFlow()

    sealed class Event {
        data class OnError(val exception: Exception) : Event()
        data class OnLoading(var isShowing: Boolean) : Event()
    }

    protected fun <T> viewModelScope(
        shouldBeShowLoading: Boolean = true,
        liveData: MutableLiveData<T>? = null,
        onSuccess: ((T) -> Unit)? = null,
        onError: ((Exception) -> Unit)? = null,
        onRequest: suspend CoroutineScope.() -> T
    ) {
        viewModelScope.launch {
            if (shouldBeShowLoading) eventChannel.send(Event.OnLoading(true))
            try {
                val response = onRequest()

                if (response is Response<*> && !response.isSuccessful)
                    throw HttpException(response)

                withContext(Dispatchers.Main) {
                    onSuccess?.invoke(response)
                    liveData?.value = response
                }

            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    onError?.invoke(e) ?: kotlin.run {
                        eventChannel.send(Event.OnError(e))
                    }
                }
            }
            if (shouldBeShowLoading) eventChannel.send(Event.OnLoading(false))
        }
    }
}
