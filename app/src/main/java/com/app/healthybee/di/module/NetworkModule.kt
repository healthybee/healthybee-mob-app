package com.app.healthybee.di.module

import android.content.Context
import com.app.healthybee.BuildConfig
import com.app.healthybee.data.remote.adapter.LiveDataCallAdapterFactory
import com.app.healthybee.data.remote.services.ApiService
import com.app.healthybee.di.interceptor.ConnectivityInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [OkHttpClientModule::class])
class NetworkModule {
    @Singleton
    @Provides
    fun provideBaseUrlString(): String {
        return BuildConfig.API_BASE_URL
    }

    @Singleton
    @Provides
    fun providesGson(): Gson {
        return GsonBuilder().create()
    }

    @Singleton
    @Provides
    fun gsonConverterFactory(gson: Gson): GsonConverterFactory {
        return GsonConverterFactory.create(gson)
    }

    @Singleton
    @Provides
    fun provideBaseRetrofit(
        context: Context,
        baseUrl: String,
        okHttpClient: OkHttpClient.Builder,
        gsonConverterFactory: GsonConverterFactory
    ): ApiService {
        okHttpClient.addInterceptor(ConnectivityInterceptor(context))

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient.build())
            .addConverterFactory(gsonConverterFactory)
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .build()
            .create(ApiService::class.java)
    }


}
