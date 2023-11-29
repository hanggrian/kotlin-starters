package com.johndoe.library

import kotlin.test.Test
import kotlin.test.assertEquals

class ViewTest {
    @Test
    fun test() {
        assertEquals("Hello World", View().text)
    }
}
