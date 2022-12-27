package com.umc.second_week.ui.main.external.course.adapt

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.umc.second_week.databinding.ListItemCourseBinding
import com.umc.second_week.data.entities.Course

class CourseAdapter(clicklistener: ItemClickListener) :
    ListAdapter<Course, CourseAdapter.MyViewHolder>(CourseDiffUtil) {

    interface ItemClickListener {
        fun onItemClick(view: View, position: Int)
        fun onItemLongClick(view: View, position: Int)
    }

    var clicklistener: ItemClickListener = clicklistener

    inner class MyViewHolder(val binding: ListItemCourseBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(user: Course) {
            binding.itemBackground.setOnClickListener {
                clicklistener.onItemClick(it, absoluteAdapterPosition)
            }
            binding.itemBackground.setOnLongClickListener{
                clicklistener.onItemLongClick(it, absoluteAdapterPosition)
                true
            }
            binding.course = user
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =
            ListItemCourseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

object CourseDiffUtil : DiffUtil.ItemCallback<Course>() {
    override fun areItemsTheSame(oldItem: Course, newItem: Course): Boolean {
        return oldItem.dataid == newItem.dataid
    }

    override fun areContentsTheSame(oldItem: Course, newItem: Course): Boolean {
        return oldItem == newItem
    }
}