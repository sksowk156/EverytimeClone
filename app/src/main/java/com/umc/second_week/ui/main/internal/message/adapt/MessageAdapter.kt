package com.umc.second_week.ui.fourth.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.umc.second_week.data.UserMessage
import com.umc.second_week.databinding.ListItemMessageBinding

class MessageAdapter(clicklistener: ItemClickListener) :
    ListAdapter<UserMessage, MessageAdapter.MyViewHolder>(UserMessageDiffUtil) {

    interface ItemClickListener {
        fun onItemClick(view: View, position: Int)
        fun onItemLongClick(view: View, position: Int)
    }

    var clicklistener: ItemClickListener = clicklistener

    inner class MyViewHolder(val binding: ListItemMessageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(user: UserMessage) {
            binding.itemBackground.setOnClickListener {
                clicklistener.onItemClick(it, absoluteAdapterPosition)
            }
            binding.itemBackground.setOnLongClickListener{
                clicklistener.onItemLongClick(it, absoluteAdapterPosition)
                true
            }
            binding.usermessage = user
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =
            ListItemMessageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

object UserMessageDiffUtil : DiffUtil.ItemCallback<UserMessage>() {
    override fun areItemsTheSame(oldItem: UserMessage, newItem: UserMessage): Boolean {
        return oldItem.dataid == newItem.dataid
    }

    override fun areContentsTheSame(oldItem: UserMessage, newItem: UserMessage): Boolean {
        return oldItem == newItem
    }
}