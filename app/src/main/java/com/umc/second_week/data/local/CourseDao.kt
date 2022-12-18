package com.umc.second_week.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.umc.second_week.data.entities.Course

@Dao
interface CourseDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCourse(course: Course) : Long

    @Insert
    suspend fun insertCourseDB(courses : List<Course>)

    @Update
    suspend fun updateCourse(course: Course)

    @Delete
    suspend fun deleteCourse(course: Course)

    @Query("DELETE FROM course_data_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM course_data_table")
    fun getAllCourse():LiveData<List<Course>>
}