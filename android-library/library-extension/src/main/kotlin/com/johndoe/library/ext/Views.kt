package com.johndoe.library.ext

import android.content.Context
import com.johndoe.library.View

public object Views {
    public fun create(context: Context): View = View(context)
}
