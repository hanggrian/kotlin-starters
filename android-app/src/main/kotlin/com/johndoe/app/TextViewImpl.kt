package com.johndoe.app

import android.widget.TextView

class TextViewImpl(val text: TextView) {
    val size: Int get() = text.width * text.height
}
