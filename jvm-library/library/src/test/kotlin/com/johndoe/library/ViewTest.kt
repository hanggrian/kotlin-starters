package com.johndoe.library

import com.google.common.truth.Truth.assertThat
import kotlin.test.Test

class ViewTest {
    @Test
    fun test() = assertThat(View().text).isEqualTo("Hello World")
}
