package com.yoyoweather.android.logic.model

import com.google.gson.annotations.SerializedName

data class PlaceRespons(val status: String,val Place : List<Place>)

data class Place(val name :String ,val location: Location,
                 @SerializedName("formatted_address") val address: String)
data class Location(val lng: String, val lat:String)
