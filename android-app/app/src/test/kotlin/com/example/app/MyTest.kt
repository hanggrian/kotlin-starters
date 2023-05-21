package com.example.app

import android.widget.EditText
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
    private lateinit var activity: MyActivity
    private lateinit var editText: EditText

    @BeforeTest
    fun setup() {
        activity = Robolectric.buildActivity(MyActivity::class.java).setup().get()
        editText = activity.findViewById(R.id.editText)
    }

    @Test
    fun test() {
        editText.setText("Hello world")
        assertEquals("Hello world", editText.text.toString())
    }
}
