package com.test.sharecar.models

import android.os.Parcel
import android.os.Parcelable


class Person(
    val id: Int,
    val name: String?,
    val email: String?,
    val phone: String?,
    val address: String?
) : Parcelable {

    private val cars = mutableListOf<Car>()
    lateinit var userName: String

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    fun addCar(car: Car): Person
    {
        cars.add(car)
        return this
    }

    fun getCars(): MutableList<Car> {
        return cars
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(email)
        parcel.writeString(phone)
        parcel.writeString(address)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Person> {
        override fun createFromParcel(parcel: Parcel): Person {
            return Person(parcel)
        }

        override fun newArray(size: Int): Array<Person?> {
            return arrayOfNulls(size)
        }
    }


}







