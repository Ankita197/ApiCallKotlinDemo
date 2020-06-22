package com.example.seconddemokotlin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.seconddemokotlin.models.CreateResponse
import com.example.seconddemokotlin.repository.Repository

class AppViewModel :ViewModel() {

    private val _userId: MutableLiveData<String> = MutableLiveData()
    val user: LiveData<CreateResponse> = Repository.getData()

    fun cancelJobs(){
        Repository.cancleJob()
    }
}