package com.test.sharecar.presentation

import android.app.Application
import android.content.Context
import android.location.Address
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.test.sharecar.CustomGeoCoder
import com.test.sharecar.data.ShareCarDatabase
import com.test.sharecar.data.ShareCarRepository
import com.test.sharecar.data.User

class UserProfileViewModel(application: Application): AndroidViewModel(application) {
    private val repository: ShareCarRepository
    var currentUser: LiveData<User>


    init {
        val db = ShareCarDatabase.getDatabase(application)
        val userDao = db.userDao()
        val tripDao = db.tripDao()
        repository = ShareCarRepository(userDao, tripDao)
        currentUser =  repository.getCurrentUser()
    }

    fun getUserAddress(address: String,context: Context): Address {
        return CustomGeoCoder(context).getAddress(address)
    }


}