package com.hdc.domain.weather.usecase

import com.hdc.domain.weather.repository.GetWeatherRepository


class GetWeatherUseCase(
    private val getWeatherRepository: GetWeatherRepository
)