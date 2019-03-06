package com.app.healthybee.di.module.activity

import com.app.healthybee.di.scope.PerActivity
import com.app.healthybee.ui.login.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Amit Bhati on 01/03/2019.
 */
@Module
abstract class ActivityModule {
    @PerActivity
    @ContributesAndroidInjector
    internal abstract fun contributeMainActivity(): MainActivity
}