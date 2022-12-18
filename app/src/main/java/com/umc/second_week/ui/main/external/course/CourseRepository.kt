package com.umc.second_week.ui.main.external.course

import androidx.lifecycle.LiveData
import com.umc.second_week.data.entities.Course
import com.umc.second_week.data.local.CourseDao

class CourseRepository(private val dao: CourseDao) {

    val courses :LiveData<List<Course>> = dao.getAllCourse()

    suspend fun insert(course: Course){
        dao.insertCourse(course)
    }

    suspend fun update(course: Course){
        dao.updateCourse(course)
    }

    suspend fun delete(course: Course){
        dao.deleteCourse(course)
    }

    suspend fun deleteAll(){
        dao.deleteAll()
    }
}