package com.hendraanggrian.app

import android.util.Log
import androidx.multidex.MultiDexApplication

class MyApp : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        Log.d("MyApp", "Started")
    }

    override fun onTerminate() {
        super.onTerminate()
        Log.d("MyApp", "Killed")
    }
}
