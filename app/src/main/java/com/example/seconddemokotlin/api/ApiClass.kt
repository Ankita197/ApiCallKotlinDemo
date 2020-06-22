package com.example.seconddemokotlin.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClass {
     val retrofit : Retrofit.Builder by lazy {
        Retrofit.Builder()
            .baseUrl("http://sd2-hiring.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())

    }

    val apiService: GetData by lazy {
        retrofit
            .build()
            .create(GetData::class.java)
    }



}



