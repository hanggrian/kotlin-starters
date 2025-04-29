package com.johndoe.library

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

public open class View : AppCompatTextView {
    public constructor(context: Context) : super(context) {
        setText(android.R.string.ok)
    }

    public constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        setText(android.R.string.ok)
    }

    public constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) :
        super(context, attrs, defStyleAttr) {
        setText(android.R.string.ok)
    }
}
