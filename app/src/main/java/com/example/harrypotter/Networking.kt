package com.example.harrypotter

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

object Networking {

    private val okHttpClient = OkHttpClient.Builder()
        .addNetworkInterceptor(
            HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY)
        )
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://hp-api.herokuapp.com/")
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val api: Api
        get() = retrofit.create()
}