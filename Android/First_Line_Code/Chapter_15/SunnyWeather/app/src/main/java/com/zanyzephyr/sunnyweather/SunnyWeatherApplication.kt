package com.zanyzephyr.sunnyweather

import android.app.Application
import android.content.Context

class SunnyWeatherApplication: Application() {

    companion object {
        lateinit var context: Context
        const val TOKEN = "gqiq0Q3jjqtg1aPF"
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}