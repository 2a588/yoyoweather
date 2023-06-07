package com.yoyoweather.android

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class YoyoweatherApplication : Application() {
    companion object {
        const val TOKEN = "CAIYUNTOKEN1234"
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context

        const val TOKENHF = "TEST"  //和风天气apitoken

        //生活指数类型
        const val INDECES_TYPE = "1,2,5"
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}