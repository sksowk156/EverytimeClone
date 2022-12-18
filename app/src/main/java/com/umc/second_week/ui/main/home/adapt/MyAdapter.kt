package com.umc.second_week.ui.main.home.adapt

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.umc.second_week.R
import com.umc.second_week.data.User

class MyAdapter(private val context:Activity, private val arrayList: ArrayList<User>):ArrayAdapter<User>(context,
    R.layout.list_item,arrayList) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater : LayoutInflater = LayoutInflater.from(context)
        val view : View = inflater.inflate(R.layout.list_item,null)

        val titles : TextView = view.findViewById(R.id.titles)
        val contents : TextView = view.findViewById(R.id.contents)

        titles.text = arrayList[position].title
        contents.text = arrayList[position].content

        return view
    }
}