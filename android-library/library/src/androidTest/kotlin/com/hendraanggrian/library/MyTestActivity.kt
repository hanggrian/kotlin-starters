package com.hendraanggrian.library

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hendraanggrian.library.test.R

open class MyTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
    }
}
