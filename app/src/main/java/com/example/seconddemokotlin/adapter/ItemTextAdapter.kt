package com.example.seconddemokotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.seconddemokotlin.R
import com.example.seconddemokotlin.models.CreateResponse

class ItemTextAdapter(val userList: ArrayList<CreateResponse.User>, val context: Context) :RecyclerView.Adapter<ItemTextAdapter.TextHolder>() {
    class TextHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            val ivBackGround=itemView.findViewById(R.id.ivBackgound) as ImageView


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false)
        return TextHolder(
            v
        )
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: TextHolder, position: Int) {
        Glide.with(context).load(userList[position].image).into(holder.ivBackGround)
    }
}