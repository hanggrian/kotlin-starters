package com.example

import android.app.Activity
import android.os.Bundle
import android.widget.FrameLayout
import com.johndoe.library.Views.create

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<FrameLayout>(R.id.layout).addView(create(this))
    }
}
