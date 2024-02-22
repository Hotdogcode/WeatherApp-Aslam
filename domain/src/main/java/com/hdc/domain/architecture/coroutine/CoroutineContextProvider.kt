package com.hdc.domain.architecture.coroutine

import kotlin.coroutines.CoroutineContext

interface CoroutineContextProvider {
    val main : CoroutineContext
    val io : CoroutineContext
}