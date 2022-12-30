package com.umc.second_week.data.remote.marketplace.`interface`

import com.umc.second_week.data.remote.marketplace.dto.MarketplaceDTO
import com.umc.second_week.data.remote.marketplace.dto.Temp
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MarketplaceRetrofitInterface {
    @GET("users")
//    @Headers("Authorization: token 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")
    suspend fun Users() : Response<MarketplaceDTO>

//    @Headers("Authorization: token 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")
    @GET("users/{login}")
    suspend fun UsersLogin(
        @Path("login") login : String
    ) : Response<Temp>
}