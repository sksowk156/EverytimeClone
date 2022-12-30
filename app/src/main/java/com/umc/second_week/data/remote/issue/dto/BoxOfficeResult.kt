package com.umc.second_week.data.remote.issue.dto

data class BoxOfficeResult(
    var boxofficeType: String? = null,
    var dailyBoxOfficeList: List<DailyBoxOffice?>? = null,
    var showRange: String? = null
)