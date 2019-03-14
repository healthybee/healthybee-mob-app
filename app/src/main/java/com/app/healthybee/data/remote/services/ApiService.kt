package com.app.healthybee.data.remote.services

import androidx.lifecycle.LiveData
import com.app.healthybee.data.remote.response.AuthResponse
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * Created by Amit Bhati on 01/03/2019.
 */
interface ApiService {

    @POST("auth")
    fun authenticate(@Header("Authorization") authorization: String,@Header("Content-Type") application :String, @Query("access_token")token:String) :LiveData<ApiResponse<AuthResponse>>
}