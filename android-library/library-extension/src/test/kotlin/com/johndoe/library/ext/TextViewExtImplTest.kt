package com.johndoe.library.ext

import android.os.Build
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.common.truth.Truth.assertThat
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.annotation.internal.DoNotInstrument
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.LOLLIPOP])
@DoNotInstrument
class TextViewExtImplTest {
    @Mock private lateinit var text: TextView

    private lateinit var mocks: AutoCloseable
    private lateinit var activity: AppCompatActivity

    @BeforeTest
    fun setup() {
        mocks = MockitoAnnotations.openMocks(this)
        Robolectric.buildActivity(TestActivity::class.java).use { controller ->
            activity = controller.setup().get()
        }
    }

    @Test
    fun test() {
        `when`(text.x).thenReturn(0f)
        `when`(text.y).thenReturn(1f)
        assertThat(TextViewExtImpl(text).position).isEqualTo("(0,1)")
        verify(text).x
        verify(text).y
    }

    @AfterTest
    @Throws(Exception::class)
    fun cleanup() = mocks.close()
}
