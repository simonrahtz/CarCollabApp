package com.test.sharecar.activities.user

import androidx.lifecycle.ViewModel
import com.test.sharecar.DataCache
import com.test.sharecar.models.Person

class SignUpViewModel: ViewModel() {

    private var id = 0

    fun createPerson(
                     name: String,
                     email: String,
                     phone: String,
                     address: String)
    {
        //store user in cache
        DataCache.currentUser[id] = Person(id,name,email,phone,address)

        //increment id to keep it unique
        id++
    }













}