package com.hdc.ui.architecture.views

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.hdc.presentation.architecture.viewmodel.BaseViewModel
import com.hdc.ui.architecture.BasePresentationToUIMapper
import com.hdc.ui.architecture.binder.ViewStateBinder

abstract class BaseActivity<VIEW_STATE: Any>: AppCompatActivity(), ViewsProvider {
    internal abstract val viewModel:BaseViewModel<VIEW_STATE>


    abstract val layoutId: Int

    abstract val mapper:BasePresentationToUIMapper

    abstract val viewStateBinder: ViewStateBinder<VIEW_STATE,ViewsProvider>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = layoutInflater.inflate(layoutId,null)
        view.bindViews()
        observeViewModel()
    }

    abstract fun View.bindViews()

    private fun observeViewModel(){
        viewModel.viewState.observe(this, ::applyViewState)
    }

    private fun applyViewState(viewState: VIEW_STATE){
        with(viewStateBinder){
            bindState(viewState)
        }
    }
}