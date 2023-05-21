package com.example

import com.example.library.Hey
import com.example.library.Yo

class MyApp {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(Hey())
            println(Yo())
        }
    }
}
