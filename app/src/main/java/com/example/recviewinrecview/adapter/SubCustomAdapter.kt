package com.example.recviewinrecview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recviewinrecview.R
import com.example.recviewinrecview.modul.SubMember

class SubCustomAdapter(private val context: Context,val memberSub: List<SubMember>): RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val footer = LayoutInflater.from(parent.context).inflate(R.layout.small_recycler,parent,false)
        return CustomSubViewHolder(footer)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
       val (status) = memberSub[position]
    }

    override fun getItemCount(): Int {
        return memberSub.size
    }
    class CustomSubViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)
}