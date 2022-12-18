package com.umc.second_week.data

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class IndivisualViewModel : ViewModel() {
    private val nick = MutableLiveData<String>()

    init{
        nick.value = "sksokw156"
    }

    fun getNick():MutableLiveData<String>{
        return nick
    }

    fun changeNick(newnick : String){
        nick.value = newnick
    }
}