package com.umc.second_week.ui.main.external.allboard.mine.adapt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.umc.second_week.R
import com.umc.second_week.data.User

// Adapter는 ViewHolder를 통해 RecylerView에서 list로 나열될 데이터의 구성요소를 찾고, Data 파일을 받아와 그 둘을 연결시켜 준다.
// ViewHolder는 Adapater에서 만들고!!, Data는 Activity나 Fragment에서 받아오자! -> 입력에 ArrayList가 들어가야함!!!!!
class MytextAdapter(userArrayList: ArrayList<User>, clicklistener: ItemClickListener) :
    RecyclerView.Adapter<MytextAdapter.MyViewHolder>() {

    interface ItemClickListener {
        fun onItemClick(view: View, position: Int)
        fun onItemLongClick(view: View, position: Int)
    }

    var users: ArrayList<User> = userArrayList
    var clicklistener: ItemClickListener = clicklistener


    // ViewHolder는 RecyclerView에 List로 나열될 데이터들의 틀이다. Adapter에선 그 틀안의 구성요소들에 무슨 데이터가 들어가야할지 정해주는 곳이다.
    // ViewHolder는 RecyclerView에 나열될 데이터의 구성요소(list_item) xml 파일에서 View들을 id로 찾아둔다.
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView
        var content: TextView
        var itembackground: ConstraintLayout

        init {
            title = itemView.findViewById(R.id.title_2)
            content = itemView.findViewById(R.id.content_2)
            itembackground = itemView.findViewById(R.id.item_background)
        }

        // bind 함수로 ViewHolder에 연결된 View들과 Data를 연결해 onBindViewHolder에서는 bind메소드만 호출하도록 한다.
        fun bind(user: User, position: Int) {
            title.text = user.title
            content.text = user.content
            itembackground.setOnClickListener {
                clicklistener.onItemClick(it, position)
            }

            itembackground.setOnLongClickListener {
                clicklistener.onItemLongClick(it, position)
                true
            }
        }
    }


    // ViewHolder를 생성한다. list_item으로 만든 데이터 틀을 ViewHolder에 inflate해준다.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val rootView: View =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item2, parent, false)
        return MyViewHolder(rootView)
    }

    // ViewHolder에 연결된 View들에 Data가 들어갈 수 있는 길을 만들어 준다.
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        // ViewHolder에서 bind 메소드를 만들면 아래 코드가 필요없다.
//        val user = users[position]
//        val viewHolder = holder as MyViewHolder
//        viewHolder.title.text = user.title
//        viewHolder.content.text = user.content

        holder.bind(users[position], position)

        // 클릭 시 필요한 동작 정의

    }

    override fun getItemCount(): Int {
        return users.size
    }

    fun setData(data: ArrayList<User>) {
        users = data
        notifyDataSetChanged()
    }
}