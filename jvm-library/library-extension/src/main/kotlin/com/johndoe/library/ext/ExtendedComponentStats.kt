package com.johndoe.library.ext

import com.johndoe.library.ComponentStats
import java.awt.Component

public class ExtendedComponentStats(component: Component) : ComponentStats(component) {
    public val position: String get() = "(${component.getX()},${component.getY()})"
}
