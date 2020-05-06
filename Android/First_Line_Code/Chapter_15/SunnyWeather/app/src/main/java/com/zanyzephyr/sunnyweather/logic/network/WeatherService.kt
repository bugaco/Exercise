package com.zanyzephyr.sunnyweather.logic.network

import com.zanyzephyr.sunnyweather.SunnyWeatherApplication
import com.zanyzephyr.sunnyweather.logic.model.DailyResponse
import com.zanyzephyr.sunnyweather.logic.model.PlaceResponse
import com.zanyzephyr.sunnyweather.logic.model.RealtimeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherService {

    @GET("v2.5/${SunnyWeatherApplication.TOKEN}/{lng},{lat}/realtime.json")
    fun getRealtimeWeather(@Path("lng") lng: String, @Path("lat") lat: String)
            : Call<RealtimeResponse.Realtime>

    @GET("v2.5/${SunnyWeatherApplication.TOKEN}/{lng},{lat}/daily.json")
    fun getDailyWeather(@Path("lng") lng: String, @Path("lat") lat: String)
            : Call<DailyResponse>
}