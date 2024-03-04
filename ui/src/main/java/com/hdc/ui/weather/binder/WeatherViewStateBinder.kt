package com.hdc.ui.weather.binder

import android.content.res.Resources
import com.hdc.presentation.weather.model.WeatherViewState
import com.hdc.ui.R
import com.hdc.ui.architecture.binder.ViewStateBinder
import com.hdc.ui.weather.views.WeatherViewsProvider

class WeatherViewStateBinder(
    private val res : Resources
):ViewStateBinder<WeatherViewState,WeatherViewsProvider>{
    override fun WeatherViewsProvider.bindState(viewState: WeatherViewState) {
        temp.text = viewState?.weatherDetail?.temp?.toString() ?: res.getString(R.string.error)
    }

}