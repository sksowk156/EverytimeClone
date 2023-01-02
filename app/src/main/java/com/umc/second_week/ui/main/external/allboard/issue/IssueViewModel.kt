package com.umc.second_week.ui.main.external.allboard.issue

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.umc.second_week.data.remote.issue.dto.BoxOfficeResult
import com.umc.second_week.data.remote.issue.dto.IssueDTO
import com.umc.second_week.data.remote.issue.service.IssueService
import kotlinx.coroutines.launch
import retrofit2.Response

class IssueViewModel (private val repository: IssueRepository) : ViewModel() {
    private var _myResponse = MutableLiveData<Response<IssueDTO>>()
    val myResponse: LiveData<Response<IssueDTO>> get() = _myResponse

    fun issue(targetDt : String){
        viewModelScope.launch {
            val response = repository.issue(targetDt)
            _myResponse.value = response
        }
    }
}