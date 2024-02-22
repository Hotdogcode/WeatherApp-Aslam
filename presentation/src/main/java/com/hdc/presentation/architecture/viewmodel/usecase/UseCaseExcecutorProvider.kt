package com.hdc.presentation.architecture.viewmodel.usecase

import com.hdc.domain.architecture.usecase.UseCaseExecutor
import kotlinx.coroutines.CoroutineScope

typealias UseCaseExecutorProvider = (coroutineScope: CoroutineScope) -> UseCaseExecutor