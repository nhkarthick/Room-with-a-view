package com.nh.roomwithview.entity

import androidx.room.DatabaseView

@DatabaseView(
    "SELECT student_table.id, student_table.name, student_table.departmentId," +
            "department.name AS departmentName FROM student_table " +
            "INNER JOIN department ON student_table.departmentId = department.id"
)
data class UserDetail(
    val id: Long,
    val name: String?,
    val departmentId: Long,
    val departmentName: String?
)