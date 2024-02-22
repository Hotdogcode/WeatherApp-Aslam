package com.hdc.domain.architecture.usecase

import com.hdc.domain.architecture.coroutine.CoroutineContextProvider
import kotlinx.coroutines.withContext

abstract class BackgroundExecutingUseCase<REQUEST,RESPONSE>(
    private val coroutineContextProvider: CoroutineContextProvider
):UseCase<REQUEST,RESPONSE> {
    final override suspend fun execute(input: REQUEST, onResult: (RESPONSE) -> Unit) {
        val result = withContext(coroutineContextProvider.io){
            executeInBack(input)
        }
        onResult(result)
    }
    abstract fun executeInBack(
        request: REQUEST
    ):RESPONSE
}