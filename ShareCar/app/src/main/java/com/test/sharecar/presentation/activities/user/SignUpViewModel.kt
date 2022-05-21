package com.test.sharecar.presentation.activities.user

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.test.sharecar.data.DataCache
import com.test.sharecar.data.User
import com.test.sharecar.data.ShareCarDatabase
import com.test.sharecar.data.ShareCarRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignUpViewModel(application: Application) : AndroidViewModel(application) {


    private val repository: ShareCarRepository

    init {
        val db = ShareCarDatabase.getDatabase(application)
        val userDao = db.userDao()
        val tripDao = db.tripDao()
        repository = ShareCarRepository(userDao, tripDao)
    }

    fun createPerson(
        name: String,
        email: String,
        phone: String,
        address: String
    ) {
        DataCache.newUser = true
        addUser(User(0, name, email, phone, address))
    }

    private fun addUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
    }

}