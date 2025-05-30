package com.johndoe.app

import javax.swing.JLabel

class JLabelImpl(val label: JLabel) {
    val size: Int get() = label.getWidth() * label.getHeight()
}
