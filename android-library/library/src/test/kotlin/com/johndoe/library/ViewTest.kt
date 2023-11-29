package com.johndoe.library

import androidx.appcompat.app.AppCompatActivity
import com.johndoe.library.test.R
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.internal.DoNotInstrument
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

@RunWith(RobolectricTestRunner::class)
@DoNotInstrument
class ViewTest {
    private lateinit var activity: AppCompatActivity
    private lateinit var view: View

    @BeforeTest
    fun setup() {
        activity = Robolectric.buildActivity(TestActivity::class.java).setup().get()
        view = activity.layoutInflater.inflate(R.layout.activity_test, null) as View
    }

    @Test
    fun test() {
        assertEquals("Hello World", view.text.toString())
    }
}
