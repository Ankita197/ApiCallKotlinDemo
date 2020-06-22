package com.example.seconddemokotlin.api

import com.example.seconddemokotlin.models.CreateResponse
import retrofit2.Call
import retrofit2.http.GET

interface GetData {
    @GET("/api/users")
    suspend fun getData(): CreateResponse
}