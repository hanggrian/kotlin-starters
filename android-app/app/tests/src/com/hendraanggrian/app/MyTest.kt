package com.hendraanggrian.app

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.runner.RunWith
import kotlin.test.Test

@LargeTest
@RunWith(AndroidJUnit4::class)
class MyTest {

    @Rule @JvmField val rule = ActivityTestRule(TestActivity::class.java)

    @Test
    fun test() {
    }
}