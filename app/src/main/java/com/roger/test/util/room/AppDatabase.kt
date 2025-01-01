package com.roger.test.util.room

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * 数据库
 */
@Database(entities = [PersonInfoBean::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun personDao(): PersonDao
}