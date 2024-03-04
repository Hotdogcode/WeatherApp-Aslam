package com.hdc.data.weather.mapper

import com.hdc.data.weather.model.WeatherDataModel
import com.hdc.domain.weather.model.WeatherResponseDomainModel

class WeatherDataToDomainMapper {
    fun toDomain(weatherDataModel: WeatherDataModel) = WeatherResponseDomainModel()
}