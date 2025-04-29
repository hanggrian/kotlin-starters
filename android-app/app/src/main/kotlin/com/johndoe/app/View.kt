package com.johndoe.app

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

open class View : AppCompatTextView {
    constructor(context: Context) : super(context) {
        setText(android.R.string.ok)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        setText(android.R.string.ok)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) :
        super(context, attrs, defStyleAttr) {
        setText(android.R.string.ok)
    }
}
