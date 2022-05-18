package com.test.sharecar.data

import com.test.sharecar.models.Car
import com.test.sharecar.models.Person
import com.test.sharecar.models.Trip


/**
 * This object is used to store car and user data locally. It will be useful even when data is
 * fetched remotely.
 * Create instance in your class to fetch the data
 */


object DataCache {
    //list of users in system
    val currentUser = mutableMapOf<Int, Person>()

    //List of cars in system
    val currentCar = mutableMapOf<Int, Car>()

    //List of trips in system
    val currentTrip = mutableMapOf<Int, Trip>()




}