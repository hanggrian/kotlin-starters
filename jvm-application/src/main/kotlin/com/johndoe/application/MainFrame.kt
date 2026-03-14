package com.johndoe.application

import java.awt.Component
import javax.inject.Inject
import javax.inject.Provider
import javax.swing.JFrame

class MainFrame(child: Component) : JFrame() {
    @Inject lateinit var statsProvider: Provider<ComponentStats>

    val stats: ComponentStats by lazy { statsProvider.get() }

    init {
        add(child)
        setSize(400, 300)
        layout = null
        isVisible = true
    }
}
