package com.umc.second_week.ui.main.external.allboard.board.adapt

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.umc.second_week.data.User
import com.umc.second_week.databinding.ListItem3Binding

class MyfourthAdapter(clicklistener: ItemClickListener) :
    RecyclerView.Adapter<MyfourthAdapter.MyViewHolder>() {

    var users = ArrayList<User>()

    interface ItemClickListener {
        fun onItemClick(view: View, position: Int)
        fun onItemLongClick(view: View, position: Int)
    }

    var clicklistener: ItemClickListener = clicklistener


    inner class MyViewHolder(val binding: ListItem3Binding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User, position: Int) {
            binding.user = user
            binding.executePendingBindings()
            binding.itemBackground.setOnClickListener {
                clicklistener.onItemClick(it, position)
            }

            binding.itemBackground.setOnLongClickListener {
                clicklistener.onItemLongClick(it, position)
                true
            }
        }
    }

    // ViewHolder를 생성한다. list_item으로 만든 데이터 틀을 ViewHolder에 inflate해준다.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
//        val rootView : View = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        val binding = ListItem3Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    // ViewHolder에 연결된 View들에 Data를 넣어준다.
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(users[position], position)
    }

    override fun getItemCount(): Int {
        return users.size
    }
}