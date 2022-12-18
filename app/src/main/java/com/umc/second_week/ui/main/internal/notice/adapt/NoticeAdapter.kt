package com.umc.second_week.ui.fourth.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.umc.second_week.data.UserNotice
import com.umc.second_week.databinding.ListItemNoticeBinding

class NoticeAdapter(clicklistener: ItemClickListener) :
    RecyclerView.Adapter<NoticeAdapter.MyViewHolder>() {

//    // 그냥 RecyclerView
//    // 데이터
//    var usernotices = ArrayList<UserNotice>()

    // 클릭 리스너
    interface ItemClickListener {
        fun onItemClick(view: View, position: Int)
        fun onItemLongClick(view: View, position: Int)
    }

    var clicklistener: ItemClickListener = clicklistener

    // asyncListDiffer
    private val asyncListDiffer: AsyncListDiffer<UserNotice> =
        AsyncListDiffer(this, UserNoticeDiffUtil)

    // 변경된 리스트 적용
        fun submitList(list: List<UserNotice>) {
        asyncListDiffer.submitList(list)
    }

    inner class MyViewHolder(val binding: ListItemNoticeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(user: UserNotice) {
            binding.itemBackground.setOnClickListener {
                clicklistener.onItemClick(it, absoluteAdapterPosition)
            }
            binding.itemBackground.setOnLongClickListener{
                Log.d("whatisthis", "absoluteAdapterPosition "+absoluteAdapterPosition.toString()+" position "+position.toString())
                clicklistener.onItemLongClick(it, absoluteAdapterPosition)
                true
            }
            binding.usernotice = user
            binding.executePendingBindings()
        }
    }

    // ViewHolder를 생성한다. list_item으로 만든 데이터 틀을 ViewHolder에 inflate해준다.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =
            ListItemNoticeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    // ViewHolder에 연결된 View들에 Data를 넣어준다.
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        // 그냥 RecyclerView
//        holder.bind(usernotices[position], position)
        // asyncListDiffer를 사용

        holder.bind(asyncListDiffer.currentList[position])
    }

//    // 그냥 RecyclerView
//    override fun getItemCount(): Int {
//        return usernotices.size
//    }

    // asyncListDiffer를 사용
    override fun getItemCount() = asyncListDiffer.currentList.size
}

// asyncListDiffer를 위한 DiffUtil 클래스
object UserNoticeDiffUtil : DiffUtil.ItemCallback<UserNotice>() {

    override fun areItemsTheSame(oldItem: UserNotice, newItem: UserNotice): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: UserNotice, newItem: UserNotice): Boolean {
        return oldItem == newItem
    }
}