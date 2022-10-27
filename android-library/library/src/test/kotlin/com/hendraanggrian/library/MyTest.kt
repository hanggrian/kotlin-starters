package com.hendraanggrian.library

import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.hendraanggrian.library.test.R
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.internal.DoNotInstrument
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

@RunWith(RobolectricTestRunner::class)
@DoNotInstrument
class MyTest {
    private lateinit var activity: AppCompatActivity
    private lateinit var editText: EditText

    @BeforeTest
    fun setup() {
        activity = Robolectric.buildActivity(MyTestActivity::class.java).setup().get()
        editText = activity.layoutInflater.inflate(R.layout.test_edittext, null) as EditText
    }

    @Test
    fun test() {
        editText.setText("Hello world")
        assertEquals("Hello world", editText.text.toString())
    }
}
