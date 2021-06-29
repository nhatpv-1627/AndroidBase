package com.vannhat.androidbase.domain.usecase.base

import com.vannhat.androidbase.utils.coroutine.ControlledRunner
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.cancellation.CancellationException

abstract class BaseCancelableUseCase<in Input : BaseInput, Output>: KoinComponent {

    protected abstract suspend fun buildUseCase(input: Input): Output
    private var controlledRunner = ControlledRunner<Unit>()

    suspend operator fun invoke(
        context: CoroutineContext = Dispatchers.IO,
        input: Input, block: BaseObserver<Output>.() -> Unit,

    ) {
        controlledRunner.cancelPreviousThenRun {
            val response = BaseObserver<Output>()
                .apply { block() }
            response()
            try {
                val result = withContext(context) {
                    buildUseCase(input)
                }
                response(result)
            } catch (cancellationException: CancellationException) {
                response(cancellationException)
            } catch (e: Exception) {
                response(e)
            }
        }
    }
}
