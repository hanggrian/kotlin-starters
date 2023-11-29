package com.johndoe.library

import android.content.Context

public object Views {
    public fun create(context: Context): View {
        return View(context)
    }
}
