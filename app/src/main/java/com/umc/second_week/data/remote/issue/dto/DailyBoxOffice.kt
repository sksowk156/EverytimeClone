package com.umc.second_week.data.remote.issue.dto

data class DailyBoxOffice(
    var audiAcc: String? = null,
    var audiChange: String? = null,
    var audiCnt: String? = null,
    var audiInten: String? = null,
    var movieCd: String? = null,
    var movieNm: String? = null,
    var openDt: String? = null,
    var rank: String? = null,
    var rankInten: String? = null,
    var rankOldAndNew: String? = null,
    var rnum: String? = null,
    var salesAcc: String? = null,
    var salesAmt: String? = null,
    var salesChange: String? = null,
    var salesInten: String? = null,
    var salesShare: String? = null,
    var scrnCnt: String? = null,
    var showCnt: String? = null
)