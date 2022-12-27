package com.umc.second_week.data.remote.marketplace.`interface`

import com.umc.second_week.data.remote.marketplace.dto.MarketplaceDTO
import retrofit2.Call
import retrofit2.http.GET

interface MarketplaceService {
    @GET("users/Kotlin/repos")
    fun kotlinUsers() : Call<MarketplaceDTO>

}