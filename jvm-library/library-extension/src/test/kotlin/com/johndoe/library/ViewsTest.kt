package com.johndoe.library

import kotlin.test.Test
import kotlin.test.assertNotNull

class ViewsTest {
    @Test
    fun test() {
        assertNotNull(Views.create())
    }
}
