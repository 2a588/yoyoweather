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
import java.lang.Exception
import java.lang.RuntimeException
import javax.xml.transform.Result
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

    fun searchLocation(location: String) = fire{
        //网路请求获取响应数据
        var locationResponse = YoyoWeatherNetwork.searchLocation(location)
        if(lcationtionResponse.code == "200"){
            var locations = locationResponse.location
            Result.success(locations)
        }else{
            Result.failure(RuntimeException("respon status is ${locationResponse.code}"))
        }
    }



    private fun <T> fire(block : suspend ()-> Result<T>) = liveData(Dispatchers.IO){
        val result = try{
            block()
        } catch (e :Exception){
            Result.failure(e)
        }
        emit(result)
    }

    fun saveLocation(location: LocationResponse.Location) = LocationDao.saveLocation(location)

    fun getSaveLocation() = LocationDao.getSavedLocation()

    fun isLocationSaved = LocationDao.isLocationSaved()


}