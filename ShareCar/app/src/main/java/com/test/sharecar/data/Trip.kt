package com.test.sharecar.data

import android.location.Address
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "trip_table")
class Trip {
    @PrimaryKey(autoGenerate = true) var tripId = 0
    @ColumnInfo(name = "date") var date = ""
    //@ColumnInfo(name = "time") val time: String?,
    @ColumnInfo(name = "destination") var destination = ""

    constructor()

    constructor(id: Int, date: String, address: String){
        this.tripId = id
        this.date = date
        this.destination = address
    }


}