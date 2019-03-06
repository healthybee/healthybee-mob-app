package com.app.healthybee.ui.login

import androidx.lifecycle.ViewModel
import com.app.healthybee.data.remote.repository.AuthRepository
import javax.inject.Inject

/**
 * Created by Amit Bhati on 26/02/2019.
 */

class LoginViewModel @Inject constructor(var authRepository: AuthRepository) : ViewModel() {



    //call when signIn button pressed
    fun authenticateUser(){
        /*authRepository.login("a@b.c","12345678")*/
    }
}