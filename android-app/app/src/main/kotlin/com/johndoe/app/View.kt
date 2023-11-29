package com.johndoe.app

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

open class View : AppCompatTextView {
    constructor(context: Context) : super(context) {
        text = "Hello World"
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        text = "Hello World"
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) :
        super(context, attrs, defStyleAttr) {
            text = "Hello World"
        }
}
