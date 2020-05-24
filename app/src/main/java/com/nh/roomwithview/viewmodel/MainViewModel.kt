package com.nh.roomwithview.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.nh.roomwithview.db.UserRoomDatabase
import com.nh.roomwithview.entity.UserDetail
import com.nh.roomwithview.repo.RoomRepository

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: RoomRepository
    val userDetailList: LiveData<List<UserDetail>>
    init {
        val userDao  =  UserRoomDatabase.getDatabase(
            application,
            viewModelScope
        ).userDao()
        repository = RoomRepository(userDao)
        userDetailList = repository.allUsers
    }
}

