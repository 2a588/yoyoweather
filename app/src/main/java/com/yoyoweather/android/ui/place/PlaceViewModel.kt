package com.yoyoweather.android.ui.place

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import retrofit2.http.Query


class PlaceViewModel :ViewModel(){

    private val searchLiveData = MutableLiveData<String>()

    val placeList = ArraryList<Place>()
    val placeLiveData = Transformations.switchMap(searchLiveData){
        query->Repository.searchPlaces(query)
    }

    fun searchPlaces(query: Query){
        searchLiveData.value = query.toString()
    }
}
