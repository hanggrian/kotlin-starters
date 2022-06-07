package com.hendraanggrian.library

import android.view.View
import android.widget.EditText
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.hendraanggrian.library.test.R
import org.junit.Rule
import org.junit.runner.RunWith
import kotlin.test.Test
import kotlin.test.assertEquals

@LargeTest
@RunWith(AndroidJUnit4::class)
class MyTest {
    @Rule @JvmField var rule = ActivityTestRule(MyTestActivity::class.java)

    @Test
    fun test() {
        onView(withId(R.id.editText)).perform(
            typeText("Hello world"),
            object : ViewAction {
                override fun getConstraints() = isAssignableFrom(EditText::class.java)
                override fun getDescription() = "Testing EditText"
                override fun perform(uiController: UiController?, view: View) = (view as EditText).run {
                    assertEquals("Hello world", view.text.toString())
                }
            }
        )
    }
}
