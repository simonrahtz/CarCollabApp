package com.test.sharecar.data

import android.location.Address
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "trip_table")
class Trip {
    @PrimaryKey(autoGenerate = true)
    var tripId = 0
    @ColumnInfo(name = "date")
    var date = ""
    @ColumnInfo(name = "time")
    var time = ""
    @ColumnInfo(name = "destination")
    var destination = ""
    @ColumnInfo(name = "distance")
    var distance = ""
    @ColumnInfo(name = "cost")
    var cost = ""
    @ColumnInfo("userId")
    var userId = ""

    constructor()

    constructor(id: Int, date: String, address: String,distance: String,cost: String) {
        this.tripId = id
        this.date = date
        this.destination = address
        this.distance = distance
        this.cost = cost

    }

    constructor(id: Int, date: String, address: String) {
        this.tripId = id
        this.date = date
        this.destination = address
    }

    constructor(distance: String, cost: String) {
        this.distance = distance
        this.cost = cost
    }


}