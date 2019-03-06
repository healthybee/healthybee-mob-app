package com.app.healthybee.data.remote.services

import androidx.lifecycle.LiveData
import com.app.healthybee.data.remote.response.AuthResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * Created by Amit Bhati on 01/03/2019.
 */
interface ApiService {

    @POST("apiService")
    @FormUrlEncoded
    fun authenticate(@Field("email") email: String, @Field("password") password: String,@Query("token")token:String) :LiveData<ApiResponse<AuthResponse>>
}