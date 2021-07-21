package com.yoyoweather.android

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class YoyoweatherApplication : Application() {
    companion object {

        const val TOKEN = "CAIYUNTOKEN1234"
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}