package com.johndoe.library

import android.view.View

public open class ViewStats(protected val view: View) {
    public val size: Int get() = view.width * view.height
}
