package com.example

import com.johndoe.library.ext.ExtendedComponentStats
import java.awt.Component
import javax.inject.Inject
import javax.inject.Provider
import javax.swing.JFrame

class MainFrame(child: Component) : JFrame() {
    @Inject lateinit var statsProvider: Provider<ExtendedComponentStats>

    val stats: ExtendedComponentStats by lazy { statsProvider.get() }

    init {
        add(child)
        setSize(400, 300)
        layout = null
        isVisible = true
    }
}
