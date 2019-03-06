package com.app.healthybee.ui.login

import com.app.healthybee.R
import com.app.healthybee.base.InjectActivity
import com.app.healthybee.databinding.ActivityMainCopyBinding

class MainActivity : InjectActivity<ActivityMainCopyBinding, LoginViewModel>() {
    override fun getLayoutId(): Int = R.layout.activity_main_copy

    override fun initObserve() {
        //Init observable here

    }


}
