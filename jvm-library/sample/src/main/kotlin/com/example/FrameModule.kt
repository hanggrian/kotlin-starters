package com.example

import com.johndoe.library.ext.ExtendedComponentStats
import dagger.Module
import dagger.Provides
import java.awt.Component

@Module
class FrameModule {
    @Provides
    fun provideStats(
        @Stats component: Component,
    ) = ExtendedComponentStats(component)

    @Provides
    @Stats
    fun provideView(frame: MainFrame): Component = frame.getComponent(0)!!
}
