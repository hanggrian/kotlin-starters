package com.johndoe.library

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import com.google.common.truth.Truth.assertThat
import com.johndoe.library.test.R
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.annotation.internal.DoNotInstrument
import kotlin.test.BeforeTest
import kotlin.test.Test

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.LOLLIPOP])
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
    fun test() = assertThat(view.text.toString()).isEqualTo(activity.getString(android.R.string.ok))
}
