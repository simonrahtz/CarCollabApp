package com.test.sharecar

import com.test.sharecar.models.Car
import com.test.sharecar.models.Person


/**
 * This object is used to store car and user data locally. It will be useful even when data is
 * fetched remotely.
 * Create instance in your class to fetch the data
 */


object DataCache {

    val currentUser = mutableMapOf<Int, Person>()

    //add a list of cars here
    val currentCar = mutableMapOf<Int, Car>()
}