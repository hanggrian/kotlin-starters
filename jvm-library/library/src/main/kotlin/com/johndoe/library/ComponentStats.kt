package com.johndoe.library

import java.awt.Component

public open class ComponentStats(protected val component: Component) {
    public val size: Int get() = component.getWidth() * component.getHeight()
}
