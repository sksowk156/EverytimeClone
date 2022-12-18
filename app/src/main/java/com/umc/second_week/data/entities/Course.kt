package com.umc.second_week.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "course_data_table")
data class Course(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "dataid")
    var dataid : Int,
    @ColumnInfo(name = "id")
    var id: String,
    @ColumnInfo(name = "content")
    var content: String
    )
