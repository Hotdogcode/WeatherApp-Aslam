package com.hdc.data.weather.datasource

import com.hdc.data.weather.model.WeatherDataModel

interface WeatherDataSource {
    fun getWeather(zip:String):WeatherDataModel
}