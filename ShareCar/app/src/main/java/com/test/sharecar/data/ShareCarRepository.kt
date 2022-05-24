package com.test.sharecar.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.*

class ShareCarRepository(private val userDao: UserDao, private val tripDao: TripDao) {

    val readAllUsers: LiveData<List<User>> = userDao.readAllData()
    val readAllTrips: LiveData<List<Trip>> = tripDao.readAllData()
    val latestTrip: LiveData<Trip> = tripDao.getLatestEntry()
    private val currentUser = MutableLiveData<User>()
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    suspend fun addUser(user: User) {
        userDao.addUser(user)
    }

    suspend fun addTrip(trip: Trip) {
        tripDao.addTrip(trip)
    }

    fun getCurrentUser(): MutableLiveData<User> {
        if (DataCache.newUser) {
            getLatestUser()
        } else {
            findUser(DataCache.currentUserId[0])
        }
        return currentUser
    }

    private fun findUser(userId: Int) {
        coroutineScope.launch(Dispatchers.Main) {
            currentUser.value = asyncFind(userId)
        }
    }

    private suspend fun asyncFind(userId: Int): User? =
        coroutineScope.async(Dispatchers.IO) {
            return@async userDao.getUserById(userId)
        }.await()

    private fun getLatestUser() {
        coroutineScope.launch(Dispatchers.Main) {
            currentUser.value = asyncFind()
        }
    }

    private suspend fun asyncFind(): User? =
        coroutineScope.async(Dispatchers.IO) {
            return@async userDao.getLatestEntry()
        }.await()


}