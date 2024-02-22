package com.hdc.presentation.weather.model

data class WeatherViewState(
    val isLoading: Boolean = false,
    val weatherDetail: WeatherPresentationModel? = null
){
    fun loading() = copy(isLoading = true)

    fun weatherDetailReady(
        weatherDetail: WeatherPresentationModel
    ) = copy(weatherDetail = weatherDetail, isLoading = false)

}