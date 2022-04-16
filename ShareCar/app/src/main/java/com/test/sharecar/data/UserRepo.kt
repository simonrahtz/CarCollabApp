package com.test.sharecar.data

import androidx.lifecycle.LiveData

class UserRepo(private val userDao: UserDao) {
    var readAllData: LiveData<List<User>> = userDao.readAllData()

    suspend fun addUser(user: User){
        userDao.addUser(user)
    }

}