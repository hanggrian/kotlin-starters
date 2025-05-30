package com.johndoe.library.ext

import android.widget.TextView
import com.johndoe.library.TextViewImpl

public class TextViewExtImpl(text: TextView) : TextViewImpl(text) {
    public val position: String get() = "(${text.x.toInt()},${text.y.toInt()})"
}
