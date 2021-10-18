package com.test.sharecar.activities.user

import androidx.lifecycle.ViewModel
import com.test.sharecar.models.Person

class LoginActivityViewModel: ViewModel() {

    var id = 0

    fun createPerson(
                     name: String,
                     email: String,
                     phone: String,
                     address: String): Person
    {
        id++
        return Person(id,name,email,phone,address)
    }


}