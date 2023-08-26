package com.example.library

import androidx.appcompat.app.AppCompatActivity
import com.example.library.test.R
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.internal.DoNotInstrument
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

@RunWith(RobolectricTestRunner::class)
@DoNotInstrument
class HelloWorldViewTest {
    private lateinit var activity: AppCompatActivity
    private lateinit var view: HelloWorldView

    @BeforeTest
    fun setup() {
        activity = Robolectric.buildActivity(TestActivity::class.java).setup().get()
        view = activity.layoutInflater.inflate(R.layout.activity_test, null) as HelloWorldView
    }

    @Test
    fun test() {
        assertEquals("Hello World", view.text.toString())
    }
}
