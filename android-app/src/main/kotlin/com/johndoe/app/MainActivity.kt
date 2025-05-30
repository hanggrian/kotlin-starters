package com.johndoe.app

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var layout: RelativeLayout

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        layout = findViewById(R.id.layout)

        val text = TextView(this)
        text.x = 50f
        text.y = 50f
        text.width = 300
        text.height = 100

        text.text = "${TextViewImpl(text).size} pixels"

        layout.addView(text)
    }
}
