package com.johndoe.library.ext

import com.johndoe.library.JLabelImpl
import javax.swing.JLabel

public class JLabelExtImpl(label: JLabel) : JLabelImpl(label) {
    public val position: String get() = "(${label.getX()},${label.getY()})"
}
