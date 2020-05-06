package com.zanyzephyr.sunnyweather.logic

import android.util.Log
import androidx.lifecycle.liveData
import com.zanyzephyr.sunnyweather.logic.model.Place
import com.zanyzephyr.sunnyweather.logic.network.SunnyWeatherNetwork
import kotlinx.coroutines.Dispatchers
import java.lang.RuntimeException

object Repository {

    fun searchPlaces(query: String) = liveData(Dispatchers.IO) {
        val result: Result<List<Place>> = try {
            val placeResponse = SunnyWeatherNetwork.searchPlaces(query)
            if (placeResponse.status == "ok") {
                val places = placeResponse.places
                Result.success(places)
            } else {
                Log.w("Repository", "${placeResponse.status}, ${placeResponse.places}")
                Result.failure(RuntimeException("response status is " +
                        "${placeResponse.status}"))
            }
        } catch (e: Exception) {
            Log.w("Repository", "${e.toString()}")
            Result.failure<List<Place>>(e)
        }
        emit(result)
    }
}