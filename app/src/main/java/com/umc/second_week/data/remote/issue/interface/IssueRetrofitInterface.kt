package com.umc.second_week.data.remote.issue.`interface`

import com.umc.second_week.data.remote.issue.dto.BoxOfficeResult
import com.umc.second_week.data.remote.issue.dto.IssueDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface IssueRetrofitInterface {
    @GET("kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json")
    suspend fun getBoxOffice(
//        @Query("key") key : String,
        @Query("targetDt") targetDt : String
    ) : Response<IssueDTO>
}