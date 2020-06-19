package com.example.seconddemokotlin.repository

import com.google.gson.annotations.SerializedName


data class CreateResponse(

   @SerializedName("status")
   val status : Boolean,
   @SerializedName("message")
    val message: String,
   @SerializedName("data")
   val data :UserData){

   data class UserData (
      @SerializedName("users")
       val userList:ArrayList<User>,

      @SerializedName("has_more")
       val has_more:Boolean
)
   data  class User (
      @SerializedName("name")

      val name: String,

      @SerializedName("image")

   val image: String,

   @SerializedName("items")

   val imaglist: ArrayList<String>

   )
   }


