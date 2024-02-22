package com.hdc.domain.weather.usecase

import com.hdc.domain.architecture.coroutine.CoroutineContextProvider
import com.hdc.domain.architecture.usecase.BackgroundExecutingUseCase
import com.hdc.domain.weather.model.WeatherRequestDomainModel
import com.hdc.domain.weather.model.WeatherResponseDomainModel
import com.hdc.domain.weather.repository.GetWeatherRepository


class GetWeatherUseCase(
    private val getWeatherRepository: GetWeatherRepository,
    coroutineContextProvider: CoroutineContextProvider
):BackgroundExecutingUseCase<WeatherRequestDomainModel,WeatherResponseDomainModel>(coroutineContextProvider){
    override fun executeInBack(request: WeatherRequestDomainModel) =
        getWeatherRepository.getWeather(request)

}