package com.example.library

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class HelloWorldView : HelloView {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) :
        super(context, attrs, defStyleAttr)

    override fun getText(): CharSequence = "${super.getText()} World"
}
