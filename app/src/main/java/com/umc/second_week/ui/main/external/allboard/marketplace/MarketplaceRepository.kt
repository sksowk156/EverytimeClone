package com.umc.second_week.ui.main.external.allboard.marketplace

import com.umc.second_week.data.remote.marketplace.dto.MarketplaceDTO
import com.umc.second_week.data.remote.marketplace.dto.Temp
import com.umc.second_week.data.remote.marketplace.service.MarketplaceService
import retrofit2.Response

class MarketplaceRepository {

    suspend fun Users() : Response<MarketplaceDTO>{
        return MarketplaceService.marketplaceservice.Users()
    }

    suspend fun UsersLogin(login : String) : Response<Temp>{
        return MarketplaceService.marketplaceservice.UsersLogin(login)
    }
}