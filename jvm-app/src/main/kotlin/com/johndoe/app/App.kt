package com.johndoe.app

import java.awt.Font
import javax.swing.JFrame
import javax.swing.JLabel

object App {
    @JvmStatic
    fun main(args: Array<String>) {
        val label = JLabel()
        label.setFont(Font("Default", Font.PLAIN, 20))
        label.setBounds(50, 50, 300, 100)
        label.setText("${JLabelImpl(label).size} pixels")

        val frame = JFrame()
        frame.add(label)
        frame.setSize(400, 300)
        frame.layout = null
        frame.isVisible = true
    }
}
