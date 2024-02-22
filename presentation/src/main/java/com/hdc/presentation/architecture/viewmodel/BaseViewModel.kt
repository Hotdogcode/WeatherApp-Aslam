package com.hdc.presentation.architecture.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hdc.presentation.architecture.viewmodel.usecase.UseCaseExecutorProvider

abstract class BaseViewModel<VIEW_STATE: Any>(
    useCaseExecutorProvider: UseCaseExecutorProvider
):ViewModel() {
    private val _viewState = MutableLiveData<VIEW_STATE>()
        .apply { value = initialState() }
    val viewState = _viewState.asLiveData()

    internal abstract fun initialState(): VIEW_STATE

    private val currentViewState: VIEW_STATE
       get() = viewState.value ?: initialState()

    internal val useCaseExecutor by lazy {
        useCaseExecutorProvider(viewModelScope)
    }

    internal fun updateViewState(newViewState: VIEW_STATE){
        _viewState.value = newViewState
    }

    internal fun updateViewState(
        updatedState: VIEW_STATE.() -> VIEW_STATE
    ) = updateViewState(currentViewState.updatedState())

    private fun <T> LiveData<T>.asLiveData() = this
}