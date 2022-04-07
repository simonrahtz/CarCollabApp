package com.test.sharecar.data

import java.util.concurrent.Flow

class Repository ( private val userDao: UserDao ) {
    val allUsers: List<User> = userDao.getAll()
}