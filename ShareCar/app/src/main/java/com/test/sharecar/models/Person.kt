package com.test.sharecar.models

data class Person(
    val id: Int,
    val name: String,
    val email: String,
    val phone: String,
    val address: String){

    private val cars = mutableListOf<Car>()

    fun addCar(car: Car): Person
    {
        cars.add(car)
        return this
    }

    fun getCars(): MutableList<Car> {
        return cars
    }






}







