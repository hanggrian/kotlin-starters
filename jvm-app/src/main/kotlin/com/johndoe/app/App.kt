package com.johndoe.app

import javax.swing.JFrame

class App {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val view = View()
            view.setBounds(10, 10, 100, 40)

            val frame = JFrame()
            frame.add(view)
            frame.setSize(100, 100)
            frame.layout = null
            frame.isVisible = true
        }
    }
}
