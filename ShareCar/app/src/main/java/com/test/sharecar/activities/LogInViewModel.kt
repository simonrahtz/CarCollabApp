package com.test.sharecar.activities

import androidx.lifecycle.ViewModel
import com.test.sharecar.models.Person

class LogInViewModel: ViewModel() {

    private var id = 0

    fun createPerson(
                     name: String,
                     email: String,
                     phone: String,
                     address: String): Person
    {
        return Person(id,name,email,phone,address)
        id++
    }









}