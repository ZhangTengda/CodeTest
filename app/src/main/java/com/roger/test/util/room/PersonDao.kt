package com.roger.test.util.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

/**
 * 数据访问对象DAO
 */
@Dao
interface PersonDao {

    @Query("SELECT * FROM personinfobean")
    fun getAll(): List<PersonInfoBean>


    @Query("SELECT * FROM personinfobean WHERE first_name = :name")
    fun loadAllByName(name: String): List<PersonInfoBean>


    @Insert
    fun insertAll(vararg personInfo: PersonInfoBean)


    @Delete
    fun delete(personInfo: PersonInfoBean)


    @Query("DELETE FROM personInfoBean")
    fun deleteAll()
}