package com.umc.second_week

import android.app.Application
import android.content.SharedPreferences
import com.umc.second_week.config.IssueInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApplicationClass : Application() {
    companion object{
        const val ISSUE_API_URL = "http://www.kobis.or.kr"
//        // 만들어져있는 SharedPreferences 를 사용해야합니다. 재생성하지 않도록 유념해주세요
//        lateinit var sSharedPreferences: SharedPreferences

//        // JWT Token Header 키 값
//        val X_ACCESS_TOKEN = "X-ACCESS-TOKEN"

        // Issue 요청 key
        val Issue_request_key = "b08827bfc21dfdcb4841d808ca556c3d"

        // Retrofit 인스턴스, 앱 실행시 한번만 생성하여 사용합니다.
        lateinit var IssueRetrofit: Retrofit
    }

    override fun onCreate() {
        super.onCreate()
//        sSharedPreferences =
//            applicationContext.getSharedPreferences("SOFTSQUARED_TEMPLATE_APP", MODE_PRIVATE)

        initRetrofit()
    }

    private fun initRetrofit(){
        val client: OkHttpClient = OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            // 로그캣에 okhttp.OkHttpClient로 검색하면 http 통신 내용을 보여줍니다.
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
//            .addNetworkInterceptor(XAccessTokenInterceptor()) // JWT 자동 헤더 전송
            .addInterceptor(IssueInterceptor())
            .build()

        // sRetrofit 이라는 전역변수에 API url, 인터셉터, Gson을 넣어주고 빌드해주는 코드
        // 이 전역변수로 http 요청을 서버로 보내면 됩니다.
        IssueRetrofit = Retrofit.Builder()
            .baseUrl(ISSUE_API_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}