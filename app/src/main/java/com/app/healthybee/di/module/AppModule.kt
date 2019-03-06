package com.app.healthybee.di.module
import android.app.Application
import android.content.Context
import com.app.healthybee.di.module.viewmodel.ViewModelModule
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule(val app: Application) {
    @Singleton
    @Provides
    fun provideContext(): Context {
        return app.applicationContext
    }
}
