package com.app.healthybee.di.module.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.healthybee.base.HealthyBeeViewModelFactory
import com.app.healthybee.di.ViewModelKey
import com.app.healthybee.ui.login.LoginViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Amit Bhati on 05/03/2019.
 */

@Module
abstract class ViewModelModule{

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindLoginViewModel(loginViewModel: LoginViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: HealthyBeeViewModelFactory): ViewModelProvider.Factory
}