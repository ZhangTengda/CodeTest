package com.roger.test.util.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "personInfoBean")
data class PersonInfoBean(

    @PrimaryKey(autoGenerate = true)
    val uid: Int,

    @ColumnInfo(name = "first_name") val name: String,

    @ColumnInfo(name = "age") val age: String
)