package com.yoyoweather.android.logic.network

import android.app.DownloadManager
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback
import kotlin.RuntimeException
import kotlin.coroutines.suspendCoroutine

object YoyoweatherNetwork{

    private val placeService = ServiceCreator.create<PlaceService>()

    suspend fun searchPlaces(query: String) = placeService.searchPlaces(query).await()

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