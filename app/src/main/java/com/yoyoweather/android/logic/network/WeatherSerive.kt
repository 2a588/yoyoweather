package com.yoyoweather.android.logic.network

import android.telecom.Call
import com.yoyoweather.android.logic.model.DailyResponse
import com.yoyoweather.android.logic.model.RealTimeResponse
import retrofit2.http.GET

interface WeatherSerive {
    @GET("a")
    fun getRealtimeWeather(@Path("lng") lng:String,@Path("lat") lat :String):
            Call<RealTimeResponse>

    @GET("b")
    fun getDailyWeather(@Path("lng") lng:String,@Path("lat") lat :String):
            Call<DailyResponse>

    @GET("v7/weather/now?key=${SunnyWeatherApplication.TOKEN}")
    fun getNowWeather(@Query("location") locationID: String) : Call<NowResponse>


    @GET("v7/weather/now?key=${SunnyWeatherApplication.TOKEN}")
    fun getDailyWeather(@Query("location") locationID: String): Call<DailyResponse>


    @GET("v7/indices/1d?type=${SunnyWeatherApplication.INDICES_TYPE}&key=${SunnyWeatherApplication.TOKEN}")
    fun getIndicesWeather(@Query("location") locationID: String): Call<IndicesResponse>

}