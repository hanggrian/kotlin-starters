package com.example

import java.awt.Font
import javax.swing.JLabel

object App {
    @JvmStatic
    fun main(args: Array<String>) {
        val label = JLabel()
        label.setFont(Font("Default", Font.PLAIN, 20))
        label.setBounds(50, 50, 300, 100)

        val frame = MainFrame(label)
        label.setText("${frame.stats.size} pixels at ${frame.stats.position}")
    }
}
