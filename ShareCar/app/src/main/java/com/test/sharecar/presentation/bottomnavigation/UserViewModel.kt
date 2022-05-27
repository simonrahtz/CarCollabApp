package com.test.sharecar.presentation.bottomnavigation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.test.sharecar.data.ShareCarDatabase
import com.test.sharecar.data.ShareCarRepository
import com.test.sharecar.data.Trip
import com.test.sharecar.data.User

class UserViewModel(application: Application) : AndroidViewModel(application) {


    private val repository: ShareCarRepository
    var currentUser: LiveData<User>
    val allTrips: LiveData<List<Trip>>


    init {
        val db = ShareCarDatabase.getDatabase(application)
        val userDao = db.userDao()
        val tripDao = db.tripDao()
        repository = ShareCarRepository(userDao, tripDao)

        currentUser =  repository.getCurrentUser()
        allTrips = repository.readAllTrips
    }




}