package com.yoyoweather.android.logic

import androidx.lifecycle.liveData
import com.yoyoweather.android.logic.model.Place
import com.yoyoweather.android.logic.network.YoyoweatherNetwork
import kotlinx.coroutines.Dispatchers
import okhttp3.Dispatcher

object Respository{

    fun searchPlaces(query : String) = liveData(Dispatchers.IO) {
        val result = try{
            var placeRespons = YoyoweatherNetwork.searchPlaces(query)
            if (placeRespons.status == "ok"){
                val places = placeRespons.places
                Result.success(places)
            }else{
                Result.failure(RuntimeException("response status is ${placeRespons.status}"))
            }
        } catch (e: Exception){
            Result.failure<List<Place>>(e)
        }
        emit(result)
    }
}