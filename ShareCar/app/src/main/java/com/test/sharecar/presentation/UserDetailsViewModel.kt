package com.test.sharecar.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.test.sharecar.data.ShareCarDatabase
import com.test.sharecar.data.User
import com.test.sharecar.data.UserRepository

class UserDetailsViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<User>>
    private val repository: UserRepository

    init {
        val userDao = ShareCarDatabase.getDatabase(application).userDao()
        repository = UserRepository(userDao)
        readAllData = repository.readAllData
    }

    fun getName(): String{
        return "peter"
    }


}