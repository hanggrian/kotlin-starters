package com.johndoe.app

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
    private lateinit var activity: MainActivity
    private lateinit var view: View

    @BeforeTest
    fun setup() {
        activity = Robolectric.buildActivity(MainActivity::class.java).setup().get()
        view = activity.layoutInflater.inflate(R.layout.activity_main, null) as View
    }

    @Test
    fun test() {
        assertEquals("Hello World", view.text.toString())
    }
}
