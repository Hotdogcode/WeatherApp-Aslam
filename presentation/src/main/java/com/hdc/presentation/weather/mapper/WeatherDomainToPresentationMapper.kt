package com.hdc.presentation.weather.mapper

import com.hdc.domain.weather.model.WeatherResponseDomainModel
import com.hdc.presentation.weather.model.WeatherPresentationModel

class WeatherDomainToPresentationMapper {
    fun toPresentation(input: WeatherResponseDomainModel)=
        WeatherPresentationModel(
            temp = input.temperature
        )
}