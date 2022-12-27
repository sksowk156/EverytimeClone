package com.umc.second_week.ui.main.external.allboard.marketplace

import com.umc.second_week.data.remote.marketplace.dto.MarketplaceDTO
import com.umc.second_week.data.remote.marketplace.service.MarketplaceService
import retrofit2.Response

class MarketplaceRepository {

    suspend fun kotlinUsers() : Response<MarketplaceDTO>{
        return MarketplaceService.marketplaceservice.kotlinUsers()
    }
}