package com.umc.second_week.ui.main.internal.notice

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.umc.second_week.data.UserNotice

class ViewpagernoticeViewModel : ViewModel() {

    // 상세페이지로 전환시 인덱스 번호를 저장하기 위함
    var data3 : Int ?= null

    private var _userMutableLiveData = MutableLiveData<List<UserNotice>>()
    val userMutableLiveData: LiveData<List<UserNotice>> get() = _userMutableLiveData

    init {
//        userArrayList = ArrayList() // 1. ArrayList를 먼저 만들어줘야
        populateList() // 2. 데이터를 초기화 할 수 있고
//        _userMutableLiveData.value = userArrayList // 3. 그 초기화된 데이터를 LiveData에 넣을 수 있다.
    }


    // 초기 데이터
    private fun populateList() {
        var userArrayList = mutableListOf<UserNotice>()
        userArrayList.add(UserNotice("자유게시판", "eefe",1))
        userArrayList.add(UserNotice("자유게시판", "ㅊㅊㅇ",2))
        userArrayList.add(UserNotice("자유게시판", "ㅠㅈ311",3))
        userArrayList.add(UserNotice("자유게시판", "kkkee",4))
        userArrayList.add(UserNotice("자유게시판", "ㅇㄹㄴㅁㅇㄻㄴㅇㄻㄴㅇㄻㄴㅇㄻㄴㅇㄻㄴㅇㄹ",5))
        userArrayList.add(UserNotice("자유게시판", "ㅈㅈㅈㅈㅈㅈㅈㅈㅈㅈㅈㅈㅈㅈㅈㅈㅈdddddddd",6))
        userArrayList.add(UserNotice("자유게시판", "xxxxxxxxxxxxxxxxxxxxxxxxxxxxx",7))
        userArrayList.add(UserNotice("자유게시판", "dfsfweㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ",8))
        userArrayList.add(UserNotice("자유게시판", "ㅈㅈeeeeeeㅈdddddddd",9))
        userArrayList.add(UserNotice("자유게시판", "xxxxxvvvbbbxbbbxxxxxxxxxxxxxxxxxxx",10))
        userArrayList.add(UserNotice("자유게시판", "dfsfwffffffeeeeeㅇㅇxaqklkllllㅇㅇㅇㅇㅇㅇㅇ",11))
        _userMutableLiveData.value = userArrayList
    }


    // 데이터를 찾아야할 데이터 설정
    fun findData(position: Int){
        data3 = position
    }

    // 데이터를 지울 때
    fun deleteData() {
        var userArrayList = mutableListOf<UserNotice>()
        userArrayList = _userMutableLiveData.value!!.toMutableList()
        Log.d("whatisthis","this is "+userArrayList.get(data3!!).toString())
        data3?.let { userArrayList.removeAt(it) }
        _userMutableLiveData.value = userArrayList
        data3 = null
    }
}