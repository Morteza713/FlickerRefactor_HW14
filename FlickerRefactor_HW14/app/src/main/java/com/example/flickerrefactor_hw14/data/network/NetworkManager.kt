package com.example.flickerrefactor_hw14.data.network

import com.github.leonardoxh.livedatacalladapter.LiveDataResponseBodyConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkManager {
    private val client = OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }).build()

    private val retrofit = Retrofit.Builder()
        .client(client)
        .baseUrl("https://api.flickr.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .addConverterFactory(LiveDataResponseBodyConverterFactory.create())
        .build()

    val service: ImageApi = retrofit.create(ImageApi::class.java)
}