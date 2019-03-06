package com.app.healthybee

import com.app.healthybee.di.component.DaggerAppComponent
import com.app.healthybee.di.module.AppModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

/**
 * Created by Amit Bhati on 01/03/2019.
 */

class HealthyBeeApplication : DaggerApplication(){
    override fun onCreate() {
        super.onCreate()

    }
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder()
            .application(this)
            .appModule(AppModule(this))
            .build()
    }

}