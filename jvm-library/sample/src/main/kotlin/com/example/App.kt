package com.example

import com.johndoe.library.ext.JLabelExtImpl
import java.awt.Font
import javax.swing.JFrame
import javax.swing.JLabel

object App {
    @JvmStatic
    fun main(args: Array<String>) {
        val label = JLabel()
        label.setFont(Font("Default", Font.PLAIN, 20))
        label.setBounds(50, 50, 300, 100)

        val impl = JLabelExtImpl(label)
        label.setText("${impl.size} pixels")
        label.setText("${label.text} at ${impl.position}")

        val frame = JFrame()
        frame.add(label)
        frame.setSize(400, 300)
        frame.layout = null
        frame.isVisible = true
    }
}
