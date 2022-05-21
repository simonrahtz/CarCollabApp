package com.test.sharecar.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.test.sharecar.data.ShareCarDatabase
import com.test.sharecar.data.Trip
import com.test.sharecar.data.ShareCarRepository

class ConfirmTripViewModel(application: Application) : AndroidViewModel(application) {

    val allTrips: LiveData<List<Trip>>
    val latestTrip: LiveData<Trip>
    private val repository: ShareCarRepository


    init {
        val db = ShareCarDatabase.getDatabase(application)
        val userDao = db.userDao()
        val tripDao = db.tripDao()
        repository = ShareCarRepository(userDao,tripDao)
        allTrips = repository.readAllTrips
        latestTrip = repository.latestTrip
    }






}