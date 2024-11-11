package com.example.neteasemusic.core.network.di

import kotlinx.serialization.json.Json
import okhttp3.Call
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

object NetworkModule {


    fun okhttpCallFactory(okHttpClient: OkHttpClient): Call.Factory = okHttpClient
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .build()
    }

    fun providesNetworkJson():Json = Json {
        ignoreUnknownKeys = true
    }
}