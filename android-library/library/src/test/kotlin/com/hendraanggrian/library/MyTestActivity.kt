package com.hendraanggrian.library

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hendraanggrian.library.test.R

class MyTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_AppCompat_Light_NoActionBar)
    }
}
