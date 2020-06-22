package com.example.seconddemokotlin.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.seconddemokotlin.api.ApiClass
import com.example.seconddemokotlin.models.CreateResponse
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object Repository {
    var job:CompletableJob?=null
    fun getData(): LiveData<CreateResponse>{
        job= Job()
        return object :LiveData<CreateResponse>(){
            override fun onActive() {
                super.onActive()
                job?.let { job ->
                    CoroutineScope(IO +job).launch{
                        val user=ApiClass.apiService.getData()
                        withContext(Main){
                           value=user
                            job.complete()
                        }
                    }

                }
            }
        }
    }
    fun cancleJob(){
        job?.cancel()
    }
}