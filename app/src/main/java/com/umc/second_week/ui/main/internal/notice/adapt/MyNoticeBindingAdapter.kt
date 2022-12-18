package com.umc.second_week.ui.main.internal.notice.adapt

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.umc.second_week.data.UserNotice
import com.umc.second_week.ui.fourth.Adapter.NoticeAdapter

object MyNoticeBindingAdapter {
    @BindingAdapter("noticeitems")
    @JvmStatic
    fun RecyclerView.setItems(items : List<UserNotice>){
        val myAdapter = this.adapter as NoticeAdapter

        // 그냥 RecylcerView
//        myAdapter.usernotices = items
//        myAdapter.notifyDataSetChanged()

        // asyncListDiffer를 사용
        myAdapter.submitList(items.toMutableList())
    }
}