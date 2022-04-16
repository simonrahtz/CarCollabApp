package com.test.sharecar.presentation.activities.user

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.sharecar.DataCache
import com.test.sharecar.data.User
import com.test.sharecar.data.UserDatabase
import com.test.sharecar.data.UserRepo
import com.test.sharecar.models.Person
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignUpViewModel (application: Application): AndroidViewModel(application) {

    private var id = 0
    private val readAllData: LiveData<List<User>>
    private val repository: UserRepo

    init {
        val userDao = UserDatabase.getDatabase(application).userDao()
        repository = UserRepo(userDao)
        readAllData = repository.readAllData

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