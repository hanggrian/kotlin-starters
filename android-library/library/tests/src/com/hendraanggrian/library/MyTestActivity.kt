package com.hendraanggrian.library

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.hendraanggrian.library.test.R

open class MyTestActivity : AppCompatActivity() {
    lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        editText = findViewById(R.id.editText)
    }
}