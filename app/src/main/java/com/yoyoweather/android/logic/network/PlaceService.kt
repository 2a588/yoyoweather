package com.yoyoweather.android.logic.network


import com.yoyoweather.android.YoyoweatherApplication
import com.yoyoweather.android.logic.model.PlaceRespons
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PlaceService{

    @GET("v2/place?token=${YoyoweatherApplication.TOKEN}&lang=zh_CN")
    fun searchPlaces(@Query("query") query: String) : Call<PlaceRespons>
}