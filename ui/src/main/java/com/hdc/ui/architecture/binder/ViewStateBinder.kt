package com.hdc.ui.architecture.binder

import com.hdc.ui.architecture.views.ViewsProvider

interface ViewStateBinder<in VIEW_STATE: Any, in VIEWS_PROVIDER: ViewsProvider> {
    fun VIEWS_PROVIDER.bindState(viewState: VIEW_STATE)
}