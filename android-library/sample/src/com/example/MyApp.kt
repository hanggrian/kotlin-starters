package com.example

import android.app.Application
import android.util.Log
import com.hendraanggrian.library.MyClass

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Log.d(MyClass().toString(), "Started")
    }

    override fun onTerminate() {
        super.onTerminate()
        Log.d(MyClass().toString(), "Killed")
    }
}