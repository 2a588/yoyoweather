package com.yoyoweather.android.logic.network

import android.app.DownloadManager
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback
import kotlin.RuntimeException
import kotlin.coroutines.suspendCoroutine

object YoyoweatherNetwork{

    private val placeService = ServiceCreator.create<PlaceService>()
    private val weatherSerive = ServiceCreator.create(WeatherSerive::class.java)

    suspend fun searchPlaces(query: String) = placeService.searchPlaces(query).await()

    suspend fun getDailyWeather(lng:String,lat:String) =
        weatherSerive.getDailyWeather(lng,lat).await()

    suspend fun getRealtimeWeather(lng: String,lat: String) =
        weatherService.getRealtimeWeather(lng,lat).await()

    private suspend fun <T> Call<T>.await() : T {
        return suspendCoroutine { continuation ->
            enqueue(object : Callback<T> {
                override fun onResponse(call: Call<T>,reponse :Response<T>){
                    var body = response.body()
                    if(body != null) continuation.resume(body)
                    else continuation.resumeWithException(
                         kotlin.RuntimeException("response body is null")
                    )
                }

                override fun onFailure(call : Call<T>, t :Throwable){
                    continuation.resumeWithException(t)
                }
            })
        }
    }
}