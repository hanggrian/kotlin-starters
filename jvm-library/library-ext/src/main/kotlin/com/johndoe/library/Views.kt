package com.johndoe.library

public object Views {
    public fun create(): View {
        val view = View()
        view.setBounds(10, 10, 100, 40)
        return view
    }
}
