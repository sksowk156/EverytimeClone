package com.umc.second_week.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.umc.second_week.ui.main.external.allboard.Event

class WriteData : ViewModel() {
    var data1 = String()
    var data2 = String()
    // 상세페이지로 전환시 인덱스 번호를 저장하기 위함
    var data3 : Int ?= null

//    private val _title = MutableLiveData<String>()
//    val title : LiveData<String> get() = _title
//    private val _contents = MutableLiveData<String>()
//    val contents : LiveData<String> get() = _contents

    private var _userMutableLiveData = MutableLiveData<ArrayList<User>>()
    val userMutableLiveData: LiveData<ArrayList<User>> get() = _userMutableLiveData

    var userArrayList: ArrayList<User>? = null

    init {
        data1 = ""
        data2 = ""
//        _title.value = null
//        _contents.value = null

        userArrayList = ArrayList() // 1. ArrayList를 먼저 만들어줘야
        populateList() // 2. 데이터를 초기화 할 수 있고
        _userMutableLiveData.value = userArrayList // 3. 그 초기화된 데이터를 LiveData에 넣을 수 있다.
    }


    // 초기 데이터
    private fun populateList() {
        userArrayList!!.add(User("asdf", "eefe"))
        userArrayList!!.add(User("ㄱㄴㅇㄹㅈ", "ㅊㅊㅇ"))
        userArrayList!!.add(User("123213", "ㅠㅈ311"))
        userArrayList!!.add(User("eddd", "kkkee"))
    }

    // 데이터를 추가할 때
    fun setData() {
        if ((data1.length != 0) && (data2.length != 0)) { // 제목과 내용이 있을 때
            // 데이터 저장 -> FourthFragment와 viewmodel 공유
//            _title.value = data1
//            _contents.value = data2

            if(data3 == null){
                userArrayList!!.add(User(data1, data2))
            }else{
                userArrayList!!.set(data3!!, User(data1,data2))
                data3 = null
            }
            // fragment 전환하기
            onButtoncompleteClick()
        } else if (data1.length != 0) { // 내용이 없을 때
            // 내용 쓰라고 경고 주기
            onEmptycontentsClick()
        } else { // 제목도 없고 내용도 없을 때 or 제목이 없을 때
            // 제목 쓰라고 경고 주기
            onEmptytitleClick()
        }
    }

    // 데이터를 찾아야할 데이터 설정
    fun findData(position: Int){
        data3 = position
        data1 = userArrayList!!.get(position).title
        data2 = userArrayList!!.get(position).content
    }

    // 데이터를 지울 때
    fun deleteData() {
        data3?.let { userArrayList!!.removeAt(it) }
        _userMutableLiveData.value = userArrayList
        eraseEditTextData()
        data3 = null
    }

    fun eraseEditTextData() { // 뒤로가기 눌렀을 때
        if(data3==null) {
            data1 = ""
            data2 = ""
        }
    }

    // Event 처리
    private val _showtitleErrorToast = MutableLiveData<Event<Boolean>>()
    private val _showcontentsErrorToast = MutableLiveData<Event<Boolean>>()
    private val _savecompleteBt = MutableLiveData<Event<Boolean>>()

    val showtitleErrorToast: LiveData<Event<Boolean>> = _showtitleErrorToast
    val showcontentsErrorToast: LiveData<Event<Boolean>> = _showcontentsErrorToast
    val savecompleteBt: LiveData<Event<Boolean>> = _savecompleteBt

    fun onEmptytitleClick() {
        _showtitleErrorToast.value = Event(true)
    }

    fun onEmptycontentsClick() {
        _showcontentsErrorToast.value = Event(true)
    }

    fun onButtoncompleteClick() {
        _savecompleteBt.value = Event(true)
    }
}