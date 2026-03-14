package com.johndoe.library.ext

import android.view.View
import com.johndoe.library.ViewStats

public class ExtendedViewStats(view: View) : ViewStats(view) {
    public val position: String get() = "(${view.x.toInt()},${view.y.toInt()})"
}
