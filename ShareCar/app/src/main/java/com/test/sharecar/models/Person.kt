package com.test.sharecar.models

import android.os.Parcel
import android.os.Parcelable


class Person(
    val id: Int,
    val name: String?,
    val email: String?,
    val phone: String?,
    val address: String?
)  {

    private val cars = mutableListOf<Car>()
    lateinit var userName: String


    fun addCar(car: Car): Person
    {
        cars.add(car)
        return this
    }

    fun getCars(): MutableList<Car> {
        return cars
    }






}







