package com.umc.second_week.ui.main.external.course.adapt

import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.umc.second_week.data.entities.Course

object MyGraduateBoardBindingAdapter {
    @BindingAdapter("graduateitems")
    @JvmStatic
    fun RecyclerView.setItems(items : List<Course>?){
        Log.d("wwwww","ddd"+items.toString())
        val myAdapter = this.adapter as CourseAdapter
        myAdapter.submitList(items?.toMutableList())
    }
}
