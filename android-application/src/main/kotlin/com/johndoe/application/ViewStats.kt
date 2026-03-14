package com.johndoe.application

import android.view.View

class ViewStats(val view: View) {
    val size: Int get() = view.width * view.height
}
