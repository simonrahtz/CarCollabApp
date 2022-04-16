package com.test.sharecar.data

import androidx.lifecycle.LiveData
import java.util.concurrent.Flow

class Repository ( private val userDao: UserDao ) {
    val readAllData: LiveData<List<User>> = userDao.getAll()

    suspend fun addUser(user: User){
        userDao.addUser(user)
    }
}