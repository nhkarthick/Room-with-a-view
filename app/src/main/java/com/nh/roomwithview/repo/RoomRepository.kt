package com.nh.roomwithview.repo

import androidx.lifecycle.LiveData
import com.nh.roomwithview.dao.UserDao
import com.nh.roomwithview.entity.UserDetail

class RoomRepository(roomDao: UserDao)  {
    val allUsers: LiveData<List<UserDetail>> = roomDao.getUserDetails()
}
