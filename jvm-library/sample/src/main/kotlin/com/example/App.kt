package com.example

import com.johndoe.library.Views
import javax.swing.JFrame

class App {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val frame = JFrame()
            frame.add(Views.create())
            frame.setSize(100, 100)
            frame.layout = null
            frame.isVisible = true
        }
    }
}
