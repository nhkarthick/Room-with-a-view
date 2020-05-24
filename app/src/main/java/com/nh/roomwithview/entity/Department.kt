package com.nh.roomwithview.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "department")
data class Department(
    @PrimaryKey
    val id: Long,
    val name: String?
)