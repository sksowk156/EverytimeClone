package com.umc.second_week.ui.main.external.allboard.marketplace

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MarketplaceViewModelFactory(private val repository: MarketplaceRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MarketplaceViewModel(repository) as T
    }
}