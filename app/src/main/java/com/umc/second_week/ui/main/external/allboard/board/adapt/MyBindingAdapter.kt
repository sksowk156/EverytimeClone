package com.umc.second_week.ui.main.external.allboard.board.adapt

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.umc.second_week.data.User

object MyBindingAdapter {
    @BindingAdapter("items")
    @JvmStatic
    fun RecyclerView.setItems(items : ArrayList<User>){
//        if(recyclerView.adapter == null){
//            recyclerView.setHasFixedSize(true)
//            recyclerView.adapter = MyfourthAdapter()
//        }

        val myAdapter = this.adapter as MyfourthAdapter
        myAdapter.users = items
        myAdapter.notifyDataSetChanged()
    }
}