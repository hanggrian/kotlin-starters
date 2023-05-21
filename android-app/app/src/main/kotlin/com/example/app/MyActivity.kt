package com.example.app

import android.graphics.Color.BLUE
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my)
        findViewById<EditText>(R.id.editText).setBackgroundColor(BLUE)
    }
}
