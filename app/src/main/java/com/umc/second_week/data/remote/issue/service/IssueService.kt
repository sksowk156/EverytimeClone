package com.umc.second_week.data.remote.issue.service

import android.util.Log
import com.umc.second_week.ApplicationClass
import com.umc.second_week.data.remote.issue.`interface`.IssueRetrofitInterface
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.Objects
import java.util.concurrent.TimeUnit

object IssueService {

//    private const val BASE_URL = "http://www.kobis.or.kr"
//
//    // HttpLoggingInterceptor
//    val loggingInterceptor = HttpLoggingInterceptor().apply {
//        level =
//            HttpLoggingInterceptor.Level.BODY
//    }
//
//    // InjectionInterceptor( 파라미터 추가하거나 헤더를 추가하거나 )
//    val injectionInterceptor = object : Interceptor {
//        override fun intercept(chain: Interceptor.Chain): Response {
//
//            // 파라미터에 추가시( 이 api는 파라미터에 인증키를 요구 했으므로 헤더가 아닌 여기엔 넣는다. )
//            val query_parameter = chain.request().url.newBuilder()
//                .addQueryParameter("key", "b08827bfc21dfdcb4841d808ca556c3d")
//                .build()
//
////            // 헤더 추가시( 보통은 여기에 인증키나 토큰을 요구한다. )
////            val request_header = chain.request().newBuilder()
////                .addHeader("Authorization", "Token " + UserInfo.headerKey)
////
////            val request = request_header
////                .url(query_parameter)
////                .build()
//
//            val request = chain.request().newBuilder()
//                .url(query_parameter)
//                .build()
//
//            return chain.proceed(request)
//        }
//    }
//
//    val errorInterceptor = object : Interceptor{
//        override fun intercept(chain: Interceptor.Chain): Response {
//            val request = chain.request()
//            val response = chain.proceed(request)
//
//            when (response.code) {
//                400 -> {
//                    Log.d("whatisthis","400")
//                }
//                401 -> {
//                    Log.d("whatisthis","401")
//                }
//                402 -> {
//                    Log.d("whatisthis","402")
//                }
//            }
//            return response
//        }
//    }
//
//    val client = OkHttpClient.Builder()
//        .addInterceptor(loggingInterceptor)
//        .addInterceptor(injectionInterceptor)
//        .addInterceptor(errorInterceptor)
//
//        .connectTimeout(10, TimeUnit.SECONDS)
//        .readTimeout(10, TimeUnit.SECONDS)
//        .writeTimeout(10, TimeUnit.SECONDS)
//        .retryOnConnectionFailure(true)
//
//        .build()
//
//    ////////////////////////////////////////////////////////////////////////
//    private val retrofit by lazy {
//        Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .client(client)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }

    val issueservice: IssueRetrofitInterface by lazy {
        ApplicationClass.IssueRetrofit.create(IssueRetrofitInterface::class.java)
    }
}

