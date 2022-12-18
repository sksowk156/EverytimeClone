package com.umc.second_week.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.umc.second_week.data.entities.Course
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [Course::class], version = 1, exportSchema = false)
abstract class CourseDatabase : RoomDatabase() {

    abstract val courseDao: CourseDao

    companion object {
        @Volatile
        private var INSTANCE: CourseDatabase? = null

        fun getInstance(context: Context): CourseDatabase? {
            synchronized(this) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        CourseDatabase::class.java,
                        "course_data_database"
                    ).addCallback(object : RoomDatabase.Callback(){
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)

                            fillInDB(context.applicationContext)
//                            db.execSQL("insert into category (id, content) values ('df','werwf')")
                        }
                    }).build()
                }
                return INSTANCE
            }
        }
        fun fillInDB(context:Context){
            CoroutineScope(Dispatchers.IO).launch {
                getInstance(context)!!.courseDao.insertCourseDB(
                    COURSE_DATA
                )
            }
        }
    }
}

private val COURSE_DATA = arrayListOf(
    Course(0,"asdf","eee"),
    Course(0,"eeee","fffff")
)