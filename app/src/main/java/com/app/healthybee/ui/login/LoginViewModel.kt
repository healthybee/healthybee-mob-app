package com.app.healthybee.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.app.healthybee.base.Resource
import com.app.healthybee.data.remote.repository.AuthRepository
import com.app.healthybee.data.remote.response.AuthResponse
import com.app.healthybee.utils.AbsentLiveData
import javax.inject.Inject


/**
 * Created by Amit Bhati on 26/02/2019.
 */

class LoginViewModel @Inject constructor(var authRepository: AuthRepository) : ViewModel() {
    private val _login: MutableLiveData<UserDetails> = MutableLiveData()
    val isOTP: MutableLiveData<Boolean> = MutableLiveData()


    val authRepo: LiveData<Resource<AuthResponse>> = Transformations
        .switchMap(_login) { input ->
            input.ifExists { email, password ->
                authRepository.login(email, password)
            }
        }


    fun setCredentials(email: String, password: String) {
        val update = UserDetails(email, password)
        _login.value = update
    }


    public data class UserDetails(val email: String, val password: String) {

        fun <T> ifExists(f: (String, String) -> LiveData<T>): LiveData<T> {
            return if (email.isBlank() || password.isBlank()) {
                AbsentLiveData.create()
            } else {
                f(email, password)
            }
        }
    }
}