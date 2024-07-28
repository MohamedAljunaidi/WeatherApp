package com.kaizen.core.di

import android.content.Context
import com.kaizen.core.ProgressDialog
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
class CoreModule {
    @Provides
    @ActivityScoped
    fun getProgressBar(@ActivityContext context: Context): ProgressDialog {
        return ProgressDialog(
            context
        )
    }
}