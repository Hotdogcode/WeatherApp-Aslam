package com.hdc.ui.weather.views

import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.hdc.ui.architecture.views.ViewsProvider

class WeatherViewsProvider : ViewsProvider{
    lateinit var zipField: EditText
    lateinit var getBtn: Button
    lateinit var temp: TextView
}