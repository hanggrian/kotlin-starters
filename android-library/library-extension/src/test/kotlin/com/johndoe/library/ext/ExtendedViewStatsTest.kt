package com.johndoe.library.ext

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.common.truth.Truth.assertThat
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.internal.DoNotInstrument
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test

@RunWith(RobolectricTestRunner::class)
@DoNotInstrument
class ExtendedViewStatsTest {
    @Mock private lateinit var view: View

    private lateinit var mocks: AutoCloseable
    private lateinit var activity: AppCompatActivity

    @BeforeTest
    fun setup() {
        mocks = MockitoAnnotations.openMocks(this)
        Robolectric
            .buildActivity(TestActivity::class.java)
            .use { activity = it.setup().get() }
    }

    @AfterTest
    @Throws(Exception::class)
    fun cleanup() = mocks.close()

    @Test
    fun test() {
        `when`(view.x).thenReturn(0f)
        `when`(view.y).thenReturn(1f)
        assertThat(ExtendedViewStats(view).position).isEqualTo("(0,1)")
        verify(view).x
        verify(view).y
    }
}
