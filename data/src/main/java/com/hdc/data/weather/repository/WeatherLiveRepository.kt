package com.hdc.data.weather.repository

import com.hdc.data.weather.datasource.WeatherDataSource
import com.hdc.data.weather.mapper.WeatherDataToDomainMapper
import com.hdc.domain.weather.repository.GetWeatherRepository

class WeatherLiveRepository(
    private val weatherDataSource: WeatherDataSource,
    private val weatherDataToDomainMapper: WeatherDataToDomainMapper
) :GetWeatherRepository{
    override fun getWeather(zip: String) =
        weatherDataToDomainMapper.toDomain(weatherDataSource.getWeather(zip))
}