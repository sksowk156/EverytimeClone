package com.umc.second_week.config

import android.util.Log
import com.umc.second_week.ApplicationClass.Companion.Issue_request_key
import okhttp3.Interceptor
import okhttp3.Response

class IssueInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        // 파라미터에 추가시( 이 api는 파라미터에 인증키를 요구 했으므로 헤더가 아닌 여기엔 넣는다. )
        val query_parameter = chain.request().url.newBuilder()
            .addQueryParameter("key", Issue_request_key)
            .build()

//            // 헤더 추가시( 보통은 여기에 인증키나 토큰을 요구한다. )
//            val request_header = chain.request().newBuilder()
//                .addHeader("Authorization", "Token " + UserInfo.headerKey)
//
//            val request = request_header
//                .url(query_parameter)
//                .build()

        val request = chain.request().newBuilder()
            .url(query_parameter)
            .build()

        // 오류 처리를 위해
        val response = chain.proceed(request)
        when (response.code) {
            400 -> {
                Log.d("whatisthis", "400")
            }
            401 -> {
                Log.d("whatisthis", "401")
            }
            402 -> {
                Log.d("whatisthis", "402")
            }
        }
        return response
    }
}