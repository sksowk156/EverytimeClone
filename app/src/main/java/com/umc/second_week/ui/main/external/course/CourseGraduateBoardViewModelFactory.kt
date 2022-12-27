package com.umc.second_week.ui.main.external.course

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CourseGraduateBoardViewModelFactory(private val repository: CourseRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CourseGraduateBoardViewModel::class.java)) {
            return CourseGraduateBoardViewModel(repository) as T
        }
        throw IllegalAccessException("Unknown View Model class")
    }
}