package com.test.sharecar.data

//not yet an entity in the database just a data class with default values
data class Car(
    val name: String = "Mazda",
    val make: String = "626",
    val address: String = "17 Brooker Street, St Marys",
    val fuelPer100km: Float = 7.6f //litres
)