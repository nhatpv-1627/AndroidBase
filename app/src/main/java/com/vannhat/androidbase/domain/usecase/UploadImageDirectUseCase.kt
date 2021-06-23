package com.vannhat.androidbase.domain.usecase

import com.vannhat.androidbase.domain.usecase.base.BaseDirectUseCase
import com.vannhat.androidbase.domain.usecase.base.NoneInput
import kotlinx.coroutines.CoroutineScope

class UploadImageDirectUseCase: BaseDirectUseCase<NoneInput, String>() {
    override suspend fun CoroutineScope.buildUseCase(input: NoneInput): String {
        return hello()
    }

    suspend fun hello() = ""
}
