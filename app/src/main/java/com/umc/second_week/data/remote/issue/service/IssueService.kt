package com.umc.second_week.data.remote.issue.service

import com.umc.second_week.data.remote.issue.`interface`.IssueRetrofitInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object IssueService {

    private val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl("http://www.kobis.or.kr")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val issueservice : IssueRetrofitInterface by lazy {
        retrofit.create(IssueRetrofitInterface::class.java)
    }
}