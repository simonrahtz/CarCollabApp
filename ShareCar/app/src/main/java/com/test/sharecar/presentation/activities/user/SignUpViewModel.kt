package com.test.sharecar.presentation.activities.user

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.test.sharecar.data.User
import com.test.sharecar.data.ShareCarDatabase
import com.test.sharecar.data.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignUpViewModel (application: Application): AndroidViewModel(application) {


    private val repository: UserRepository

    init {
        val db = ShareCarDatabase.getDatabase(application)
        val userDao = db.userDao()
        val tripDao = db.tripDao()
        repository = UserRepository(userDao,tripDao)
    }


    fun createPerson(
                     name: String,
                     email: String,
                     phone: String,
                     address: String)
    {

        addUser(User(0,name,email,phone,address))
        //store user in cache
        //DataCache.currentUser[id] = Person(id,name,email,phone,address)

        //increment id to keep it unique
        //id++
    }

    private fun addUser(user: User){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
    }

}