package com.umc.second_week.data.remote.marketplace.service

import android.util.Log
import com.umc.second_week.data.remote.marketplace.`interface`.MarketplaceRetrofitInterface
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MarketplaceService {
    private val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val marketplaceservice : MarketplaceRetrofitInterface by lazy {
        retrofit.create(MarketplaceRetrofitInterface::class.java)
    }
}

