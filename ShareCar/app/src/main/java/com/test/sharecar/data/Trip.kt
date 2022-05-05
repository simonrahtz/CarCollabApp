package com.test.sharecar.data

import android.location.Address
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "trip_table")
data class Trip (
    @PrimaryKey(autoGenerate = true) val tripId: Int,
    @ColumnInfo(name = "date") val date: String?,
    @ColumnInfo(name = "time") val time: String?,
    @ColumnInfo(name = "destination") val destination: String?,

    )