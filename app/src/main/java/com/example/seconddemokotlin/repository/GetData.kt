package com.example.seconddemokotlin.repository

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GetData {
    @GET("/api/users")
    fun getData(): Call<CreateResponse>
}