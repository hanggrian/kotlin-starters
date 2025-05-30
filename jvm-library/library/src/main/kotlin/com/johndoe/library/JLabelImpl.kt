package com.johndoe.library

import javax.swing.JLabel

public open class JLabelImpl(protected val label: JLabel) {
    public val size: Int get() = label.getWidth() * label.getHeight()
}
