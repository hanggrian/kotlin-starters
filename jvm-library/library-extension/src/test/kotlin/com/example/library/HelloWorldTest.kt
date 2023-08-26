package com.example.library

import kotlin.test.Test
import kotlin.test.assertEquals

class HelloWorldTest {
    @Test
    fun test() {
        assertEquals("Hello World", HelloWorld().toString())
    }
}
