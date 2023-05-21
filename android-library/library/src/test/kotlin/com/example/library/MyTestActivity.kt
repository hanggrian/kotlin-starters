package com.example.library

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.library.test.R

class MyTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_AppCompat_Light_NoActionBar)
    }
}
