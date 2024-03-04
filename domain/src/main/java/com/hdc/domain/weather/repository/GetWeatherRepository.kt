package com.hdc.domain.weather.repository

import com.hdc.domain.weather.model.WeatherResponseDomainModel

interface GetWeatherRepository {
    fun getWeather(zip : String): WeatherResponseDomainModel
}