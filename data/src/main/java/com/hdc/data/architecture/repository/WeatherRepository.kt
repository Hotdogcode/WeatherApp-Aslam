package com.hdc.data.architecture.repository

import com.hdc.data.weather.model.WeatherDataModel

interface WeatherRepository {
    fun getWeather(zip : String):WeatherDataModel
}