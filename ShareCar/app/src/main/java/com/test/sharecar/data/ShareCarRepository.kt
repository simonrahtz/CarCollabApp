package com.test.sharecar.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.*

class ShareCarRepository(private val userDao: UserDao, private val tripDao: TripDao) {

    val readAllUsers: LiveData<List<User>> = userDao.readAllData()
    val readAllTrips: LiveData<List<Trip>> = tripDao.readAllData()
    val latestTrip: LiveData<Trip> = tripDao.getLatestEntry()
    val currentUser : LiveData<User> = userDao.getLatestEntry()
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    suspend fun addUser (user: User){
        userDao.addUser(user)
    }

    suspend fun addTrip (trip: Trip){
        tripDao.addTrip(trip)
    }





}