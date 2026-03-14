package com.johndoe.application

import dagger.Module
import dagger.Provides
import java.awt.Component

@Module
class FrameModule {
    @Provides
    fun provideStats(
        @Stats component: Component,
    ) = ComponentStats(component)

    @Provides
    @Stats
    fun provideView(frame: MainFrame): Component = frame.getComponent(0)!!
}
