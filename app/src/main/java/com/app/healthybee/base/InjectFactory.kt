package com.app.healthybee.base

import androidx.lifecycle.ViewModelProvider

interface InjectFactory {
    fun initFactory(): ViewModelProvider.Factory?
}