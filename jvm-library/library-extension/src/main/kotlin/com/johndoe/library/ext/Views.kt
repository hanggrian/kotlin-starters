package com.johndoe.library.ext

import com.johndoe.library.View

public object Views {
    public fun create(): View {
        val view = View()
        view.setBounds(10, 10, 100, 40)
        return view
    }
}
