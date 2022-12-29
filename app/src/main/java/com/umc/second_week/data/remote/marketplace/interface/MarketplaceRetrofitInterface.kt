package com.umc.second_week.data.remote.marketplace.`interface`

import com.umc.second_week.data.remote.marketplace.dto.MarketplaceDTO
import com.umc.second_week.data.remote.marketplace.dto.MarketplaceDTOItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface MarketplaceRetrofitInterface {
    @GET("users")
    @Headers("Authorization: token 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")
    suspend fun Users() : Response<MarketplaceDTO>

    @Headers("Authorization: token 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")
    @GET("users/{login}")
    suspend fun UsersLogin(
        @Path("login") login : String
    ) : Response<MarketplaceDTOItem>
}