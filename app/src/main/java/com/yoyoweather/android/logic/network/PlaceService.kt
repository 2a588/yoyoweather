package com.yoyoweather.android.logic.network

import androidx.room.Query
import com.yoyoweather.android.YoyoweatherApplication
import com.yoyoweather.android.logic.model.PlaceRespons

interface PlaceService{

    @GET("v2/place?token=${YoyoweatherApplication.TOKEN}&lang=zh_CN")
    fun searchPlaces(@Query("query") query: String) : Call<PlaceRespons>
}