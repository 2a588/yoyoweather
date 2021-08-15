package com.yoyoweather.android.logic

import androidx.lifecycle.liveData
import okhttp3.Dispatcher
import androidx.lifecycle.liveData
//import com.yoyoweather.android.logic.dao.PlaceDao
import com.yoyoweather.android.logic.model.Place
//import com.yoyoweather.android.logic.model.Weather
import com.yoyoweather.android.logic.network.YoyoweatherNetwork
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlin.coroutines.CoroutineContext

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