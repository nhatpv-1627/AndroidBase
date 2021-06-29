package com.vannhat.androidbase.domain.usecase.base

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent
import java.lang.Exception
import kotlin.coroutines.CoroutineContext

abstract class BaseDirectUseCase<in Input : BaseInput, Output>: KoinComponent {
    protected abstract suspend fun CoroutineScope.buildUseCase(input: Input): Output

    suspend operator fun invoke(
        input: Input,
        context: CoroutineContext = Dispatchers.IO
    ): Output = withContext(context) {
        return@withContext try {
            buildUseCase(input)
        } catch (e: Exception) {
            throw  e
        }
    }
}
