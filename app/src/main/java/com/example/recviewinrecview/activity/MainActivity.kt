package com.example.recviewinrecview.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.SnapHelper
import com.example.recviewinrecview.R
import com.example.recviewinrecview.adapter.CustomAdapter
import com.example.recviewinrecview.modul.Member
import com.example.recviewinrecview.modul.SubMember
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.big_recycler.*
import kotlinx.android.synthetic.main.item_list.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()

        val members = prepareMemberList()
         refreshAdapter(members)

    }

    private fun initView(){
        recycler_outer.layoutManager = GridLayoutManager(this,1)
    }

    fun refreshAdapter(members: List<Member>){
        val adapter = CustomAdapter(this,members)
         recycler_outer.adapter = adapter
    }

    fun prepareMemberList(): List<Member>{
    val member = ArrayList<Member>()

        for(i in 0..6){
            if(i == 1||i == 10){
                member.add(Member("Jalal"+i,"bin Dilshod"+i,prepareSubMember()))
            } else {
                member.add(Member("Kamor"+i,"Tumor"+i,ArrayList<SubMember>()))
            }
        }
return member
    }


fun prepareSubMember():List<SubMember>{

    val members = ArrayList<SubMember>()
    for(i in 0..2){
        members.add(SubMember("offline"))
    }
return members
}
}