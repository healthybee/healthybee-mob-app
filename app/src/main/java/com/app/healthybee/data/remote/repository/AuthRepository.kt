package com.app.healthybee.data.remote.repository

import android.util.Base64
import androidx.lifecycle.LiveData
import com.app.healthybee.AppExecutors
import com.app.healthybee.base.NetworkBoundResource
import com.app.healthybee.base.Repository
import com.app.healthybee.base.Resource
import com.app.healthybee.data.remote.response.AuthResponse
import com.app.healthybee.data.remote.services.ApiResponse
import com.app.healthybee.data.remote.services.ApiService
import javax.inject.Inject

/**
 * Created by Amit Bhati on 01/03/2019.
 */
class AuthRepository @Inject constructor(
    private val appExecutors: AppExecutors,
    private val apiService: ApiService

) : Repository {
    private val token: String = "3biGa1hRAPnwN7Ad9hdMOhm6NGBGC4MU"
    fun login(email: String, password: String): LiveData<Resource<AuthResponse>> {
        return object : NetworkBoundResource<AuthResponse>(appExecutors) {
            override fun createCall(): LiveData<ApiResponse<AuthResponse>> {
                val credentials: String = email.trim() + ":" + password.trim()
                val basic: String =
                    "Basic " + Base64.encodeToString(credentials.toByteArray(), Base64.NO_WRAP);
                val content:String = "application/json"
                return apiService.authenticate(basic,content, token)
            }

        }.asLiveData()

    }
}