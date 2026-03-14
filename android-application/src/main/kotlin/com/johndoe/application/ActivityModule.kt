package com.johndoe.application

import android.app.Activity
import android.view.View
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class ActivityModule {
    @Provides
    fun provideStats(
        @Stats view: View,
    ) = ViewStats(view)

    @Provides
    @Stats
    fun provideView(activity: Activity): View = activity.findViewById(R.id.text)
}
