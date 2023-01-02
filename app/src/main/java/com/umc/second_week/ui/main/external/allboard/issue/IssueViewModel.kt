package com.umc.second_week.ui.main.external.allboard.issue

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.umc.second_week.data.remote.issue.dto.BoxOfficeResult
import com.umc.second_week.data.remote.issue.dto.IssueDTO
import com.umc.second_week.data.remote.issue.service.IssueService
import com.umc.second_week.data.remote.marketplace.service.MarketplaceService.marketplaceservice
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class IssueViewModel (private val repository: IssueRepository) : ViewModel() {
    private var _myResponse = MutableLiveData<Response<IssueDTO>>()
    val myResponse: LiveData<Response<IssueDTO>> get() = _myResponse

//    // fragment에서 API 초기화
//    fun issue(targetDt : String){
//        viewModelScope.launch {
//            val response = repository.issue(targetDt)
//            _myResponse.value = response
//        }
//    }

    // application class에서 API 초기화
    fun issueAPI(targetDt: String) {

        CoroutineScope(Dispatchers.IO).launch {
            val response =IssueService.issueservice.getBoxOffice(targetDt)
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    response.body()?.let { result ->
                        _myResponse.value = response
                    }
                } else {
                    Log.d("TAG", response.code().toString())
                }
            }
        }
    }
}