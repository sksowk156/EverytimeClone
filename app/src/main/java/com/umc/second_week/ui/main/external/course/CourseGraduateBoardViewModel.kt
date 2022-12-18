package com.umc.second_week.ui.main.external.course

import androidx.databinding.Observable
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.umc.second_week.data.entities.Course
import kotlinx.coroutines.launch

class CourseGraduateBoardViewModel(private val repository: CourseRepository) : ViewModel(), Observable {

    val courses : LiveData<List<Course>>
//    private var _userMutableLiveData = MutableLiveData<List<Course>>()
//    val userMutableLiveData: LiveData<List<Course>> get() = _userMutableLiveData

    init {
        courses = repository.courses
    }

    fun insert(course: Course) {
        viewModelScope.launch {
            repository.insert(course)
        }
    }

    fun update(course: Course){
        viewModelScope.launch {
            repository.update(course)
        }
    }

    fun delete(course: Course){
        viewModelScope.launch {
            repository.delete(course)
        }
    }

    fun clearAll(){
        viewModelScope.launch {
            repository.deleteAll()
        }
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }
}