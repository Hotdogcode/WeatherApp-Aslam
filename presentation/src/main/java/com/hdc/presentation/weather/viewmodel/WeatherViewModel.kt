package com.hdc.presentation.weather.viewmodel

import com.hdc.domain.weather.model.WeatherResponseDomainModel
import com.hdc.domain.weather.usecase.GetWeatherUseCase
import com.hdc.presentation.architecture.viewmodel.BaseViewModel
import com.hdc.presentation.architecture.viewmodel.usecase.UseCaseExecutorProvider
import com.hdc.presentation.weather.mapper.WeatherDomainToPresentationMapper
import com.hdc.presentation.weather.model.WeatherViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val getWeatherUseCase: GetWeatherUseCase,
    private val weatherDomainToPresentationMapper: WeatherDomainToPresentationMapper,
    useCaseExecutorProvider: UseCaseExecutorProvider
):BaseViewModel<WeatherViewState>(useCaseExecutorProvider){
    override fun initialState() = WeatherViewState()

    fun onGetWeather(zip:String){
        updateViewState(WeatherViewState::loading)
    }

    private fun fetchWeatherDetails(zip:String){
        useCaseExecutor.execute(
            getWeatherUseCase, zip, ::showWeatherDetails
        )
    }

    private fun showWeatherDetails(details : WeatherResponseDomainModel){
        val weatherDetails = weatherDomainToPresentationMapper.toPresentation(details)
        updateViewState{
            weatherDetailReady(weatherDetails)
        }
    }

}