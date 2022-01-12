package com.example.recviewinrecview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.example.recviewinrecview.R
import com.example.recviewinrecview.modul.Member
import com.example.recviewinrecview.modul.SubMember


class CustomAdapter(val context: Context,val member: List<Member>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {

      companion object{
           private val TYPE_ITEM_VIEW = 0
           private val TYPE_ITEM_LIST = 1
      }

    override fun getItemViewType(position: Int): Int {
        return if (member[position].memberSub.isNotEmpty()) TYPE_ITEM_LIST else TYPE_ITEM_VIEW
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
       if(viewType == TYPE_ITEM_LIST){
           val header = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
             return CustomListHolder(header)
       }
        val footer = LayoutInflater.from(parent.context).inflate(R.layout.big_recycler,parent,false)
        return CustomViewtHolder(footer)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
       val member = member[position]

        if(holder is CustomViewtHolder){
        }
        if(holder is CustomListHolder){
        val recyclerView =holder.recyclerView
//            recyclerView.layoutManager = GridLayoutManager(context,1)

            val snap = PagerSnapHelper()
            snap.attachToRecyclerView(recyclerView)

         val memberSub = member.memberSub
            refreshSubAdapter(recyclerView,memberSub)

        }

    }

    fun refreshSubAdapter(recyclerView: RecyclerView,subMember: List<SubMember>){
        val adapter = SubCustomAdapter(context,subMember)
        recyclerView.adapter = adapter
    }

    override fun getItemCount(): Int {
        return member.size
    }
    class CustomViewtHolder(itemView: View):RecyclerView.ViewHolder(itemView){

    }

    class CustomListHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var recyclerView:RecyclerView = itemView.findViewById(R.id.recycler_inner)


    }

}