package com.umc.second_week.ui.main.external.allboard.marketplace

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.umc.second_week.data.remote.marketplace.dto.MarketplaceDTO
import com.umc.second_week.data.remote.marketplace.dto.Temp
import kotlinx.coroutines.launch
import retrofit2.Response

class MarketplaceViewModel(private val repository: MarketplaceRepository) : ViewModel() {
    private var _myResponse = MutableLiveData<Response<MarketplaceDTO>>()
    val myResponse: LiveData<Response<MarketplaceDTO>> get() = _myResponse

    private var _myResponse_2 = MutableLiveData<Response<Temp>>()
    val myResponse_2: LiveData<Response<Temp>> get() = _myResponse_2


//    val myResponse: MutableLiveData<Response<MarketplaceDTO>> = MutableLiveData()

    fun Users() {
        viewModelScope.launch {
            val response = repository.Users()
            _myResponse.value = response
        }
    }

    fun UsersLogin(login:String){
        viewModelScope.launch {
            val response = repository.UsersLogin(login)
            _myResponse_2.value = response
        }
    }
}