package com.umc.second_week.ui.main.external.allboard.marketplace

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.umc.second_week.data.remote.marketplace.dto.MarketplaceDTO
import kotlinx.coroutines.launch
import retrofit2.Response

class MarketplaceViewModel(private val repository : MarketplaceRepository) : ViewModel() {
    val myResponse : MutableLiveData<Response<MarketplaceDTO>> = MutableLiveData()

    fun kotlinUsers(){
        viewModelScope.launch {
            val response = repository.kotlinUsers()
            myResponse.value = response
        }
    }
}