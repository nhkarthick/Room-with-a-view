package com.nh.roomwithview.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nh.roomwithview.entity.Department
import com.nh.roomwithview.entity.User
import com.nh.roomwithview.entity.UserDetail

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(user: User)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(department: Department)

    @Query("DELETE FROM user_table")
    fun deleteAll()

    @Query("SELECT * FROM UserDetail")
    fun getUserDetails(): LiveData<List<UserDetail>>
}
