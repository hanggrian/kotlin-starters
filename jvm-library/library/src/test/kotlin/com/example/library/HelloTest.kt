package com.example.library

import kotlin.test.Test
import kotlin.test.assertEquals

class HelloTest {
    @Test
    fun test() {
        assertEquals("Hello", Hello().toString())
    }
}
