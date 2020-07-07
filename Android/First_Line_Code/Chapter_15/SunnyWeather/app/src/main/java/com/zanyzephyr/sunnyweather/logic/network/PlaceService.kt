package com.zanyzephyr.sunnyweather.logic.network

import com.zanyzephyr.sunnyweather.SunnyWeatherApplication
import com.zanyzephyr.sunnyweather.logic.model.PlaceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PlaceService {

    @GET("v2/place?token=${SunnyWeatherApplication.TOKEN}")
    fun searchPlaces(@Query("query") query: String): Call<PlaceResponse>
}