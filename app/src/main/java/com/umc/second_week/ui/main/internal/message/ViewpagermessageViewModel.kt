package com.umc.second_week.ui.main.internal.message

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.umc.second_week.data.UserMessage

class ViewpagermessageViewModel : ViewModel() {
    var data3 : Int ?= null

    private var _userMutableLiveData = MutableLiveData<ArrayList<UserMessage>>()
    val userMutableLiveData: LiveData<ArrayList<UserMessage>> get() = _userMutableLiveData

    var userArrayList: ArrayList<UserMessage>? = null

    init {
        userArrayList = ArrayList() // 1. ArrayList를 먼저 만들어줘야
        populateList() // 2. 데이터를 초기화 할 수 있고
        _userMutableLiveData.value = userArrayList // 3. 그 초기화된 데이터를 LiveData에 넣을 수 있다.
    }


    // 초기 데이터
    private fun populateList() {
        userArrayList!!.add(UserMessage("익명", "eefe",1))
        userArrayList!!.add(UserMessage("익명", "ㅊㅊㅇ",2))
        userArrayList!!.add(UserMessage("익명", "ㅠㅈ311",3))
        userArrayList!!.add(UserMessage("익명", "kkkee",4))
        userArrayList!!.add(UserMessage("익명", "gggg",5))
        userArrayList!!.add(UserMessage("익명", "xxxx",6))
        userArrayList!!.add(UserMessage("익명", "qqqqqq",7))
        userArrayList!!.add(UserMessage("익명", "bbbbbbbbbbbbbbbbbbbb",8))
    }
    // 데이터를 찾아야할 데이터 설정
    fun findData(position: Int){
        data3 = position
    }

    // 데이터를 지울 때
    fun deleteData() {
        data3?.let { userArrayList!!.removeAt(it) }
        _userMutableLiveData.value = userArrayList
        data3 = null
    }
}