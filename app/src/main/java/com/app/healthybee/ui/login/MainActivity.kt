package com.app.healthybee.ui.login

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.app.healthybee.R
import com.app.healthybee.base.InjectActivity
import com.app.healthybee.databinding.ActivityMainCopyBinding
import kotlinx.android.synthetic.main.activity_main_copy.*

class MainActivity : InjectActivity<ActivityMainCopyBinding, LoginViewModel>() {
    override fun getLayoutId(): Int = R.layout.activity_main_copy

    override fun initObserve() {
        //Init observable here
        mViewModel.authRepo.observe(this, Observer { userResponse ->
            Log.d("data received:", userResponse.data.toString())
        })

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        btn_login.setOnClickListener {
            mViewModel.setCredentials(
                mBinding.edtEmailId.text.toString().trim(),
                mBinding.edtLoginPassword.text.toString().trim()
            )
        }
    }
}
