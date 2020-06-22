package com.example.seconddemokotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.seconddemokotlin.models.CreateResponse
import com.example.seconddemokotlin.adapter.ItemTextAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Callback as Callback

class MainActivity : AppCompatActivity() {

  private var userList = arrayListOf<CreateResponse.User>()
    lateinit var viewModel:AppViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        makeApiCall()
    }
    fun setAdapter(){
        val adapter = ItemTextAdapter(
            userList,
            this@MainActivity
        )

        //now adding the adapter to recyclerview
        rvItem.adapter = adapter
    }
    fun makeApiCall(){

           viewModel=ViewModelProvider(this).get(AppViewModel::class.java)
            viewModel.user.observe(this, Observer {
                user->println("Deebug: $user")
                userList=user.data.userList
                setAdapter()
            })


    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.cancelJobs()
    }
}


