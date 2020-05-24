package com.nh.roomwithview.entity

import androidx.room.DatabaseView

@DatabaseView("SELECT user_table.id, user_table.name, user_table.departmentId," +
        "department.name AS departmentName FROM user_table " +
        "INNER JOIN department ON user_table.departmentId = department.id")
data class UserDetail(
    val id: Long,
    val name: String?,
    val departmentId: Long,
    val departmentName: String?
)