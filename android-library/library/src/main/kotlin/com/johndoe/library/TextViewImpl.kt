package com.johndoe.library

import android.widget.TextView

public open class TextViewImpl(protected val text: TextView) {
    public val size: Int
        get() = text.width * text.height
}
