package com.umc.second_week.ui.main.internal.message.adapt

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.umc.second_week.data.UserMessage
import com.umc.second_week.ui.fourth.Adapter.MessageAdapter

object MyMessageBindingAdapter {
    @BindingAdapter("messageitems")
    @JvmStatic
    fun RecyclerView.setItems(items : ArrayList<UserMessage>){
        val myAdapter = this.adapter as MessageAdapter
        myAdapter.submitList(items.toMutableList())
    }
}