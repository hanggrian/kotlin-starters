package com.johndoe.library

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

public open class View : AppCompatTextView {
    public constructor(context: Context) : super(context) {
        text = "Hello World"
    }

    public constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        text = "Hello World"
    }

    public constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) :
        super(context, attrs, defStyleAttr) {
            text = "Hello World"
        }
}
