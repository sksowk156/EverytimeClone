package com.umc.second_week.ui.main.external.allboard.issue

import android.util.Log
import com.umc.second_week.data.remote.issue.dto.BoxOfficeResult
import com.umc.second_week.data.remote.issue.dto.IssueDTO
import com.umc.second_week.data.remote.issue.service.IssueService
import retrofit2.Response

class IssueRepository {
    suspend fun issue(key : String, targetDt : String) : Response<IssueDTO> {
        Log.d("whatisthis",IssueService.issueservice.getBoxOffice(key, targetDt).toString())
        return IssueService.issueservice.getBoxOffice(key, targetDt)
    }
}