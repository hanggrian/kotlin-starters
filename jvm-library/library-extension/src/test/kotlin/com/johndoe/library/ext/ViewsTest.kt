package com.johndoe.library.ext

import kotlin.test.Test
import kotlin.test.assertNotNull

class ViewsTest {
    @Test
    fun test() {
        assertNotNull(Views.create())
    }
}
