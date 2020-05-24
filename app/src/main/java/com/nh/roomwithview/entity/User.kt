package com.nh.roomwithview.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey
    val id: Long,
    val name: String?,
    val departmentId: Long
)