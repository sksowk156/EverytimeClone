package com.umc.second_week.data.remote.marketplace.`interface`

import com.umc.second_week.data.remote.marketplace.dto.MarketplaceDTO
import retrofit2.Response
import retrofit2.http.GET

interface MarketplaceRetrofitInterface {
    @GET("users/Kotlin/repos")
    suspend fun kotlinUsers() : Response<MarketplaceDTO>
}