package com.umc.second_week.ui.main.external.allboard.issue

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class IssueViewModelFactory (private val repository: IssueRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return IssueViewModel(repository) as T
    }
}