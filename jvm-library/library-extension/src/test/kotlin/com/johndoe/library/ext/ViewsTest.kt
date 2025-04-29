package com.johndoe.library.ext

import com.google.common.truth.Truth.assertThat
import kotlin.test.Test

class ViewsTest {
    @Test
    fun test() = assertThat(Views.create()).isNotNull()
}
