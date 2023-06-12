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





}