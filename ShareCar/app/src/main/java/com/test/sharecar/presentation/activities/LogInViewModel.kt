package com.test.sharecar.presentation.activities

import android.app.Application
import android.widget.EditText
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.test.sharecar.data.*

class LogInViewModel(application: Application) : AndroidViewModel(application) {

    val allUsers: LiveData<List<User>>
    private val repository: ShareCarRepository
    private val users = listOf(User(0,"simon"))



    init {
        val db = ShareCarDatabase.getDatabase(application)
        val userDao = db.userDao()
        val tripDao = db.tripDao()
        repository = ShareCarRepository(userDao,tripDao)
        allUsers = repository.readAllUsers

    }

    fun searchForUser(name: String, users: List<User>): Boolean {

        var userExists = false
        users.forEach{
            if(it.name == name){
                DataCache.currentUserId.clear()
                DataCache.currentUserId.add(it.userId)
                return true}
        }
        return userExists
    }
}