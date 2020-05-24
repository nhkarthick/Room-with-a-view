package com.nh.roomwithview.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student_table")
data class User(
    @PrimaryKey
    val id: Long,
    val name: String?,
    val departmentId: Long
)