package com.johndoe.application

import java.awt.Component

open class ComponentStats(protected val component: Component) {
    val size: Int get() = component.getWidth() * component.getHeight()
}
