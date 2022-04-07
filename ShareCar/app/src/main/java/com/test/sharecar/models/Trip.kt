package com.test.sharecar.models

import android.location.Address
import android.location.Location
import android.location.LocationManager
import com.google.android.gms.maps.model.LatLng
import java.util.*

class Trip(
    //val tripId: Int,
    private val startAddress: LatLng,
    private val endAddress: LatLng

        ) {

    val date: Date?
        get() {
            TODO()
        }

    fun calculateDistance () :Float {
        return latLngToLocation(startAddress).distanceTo(
            latLngToLocation(endAddress)
        )

    }
    fun getStartAddress(): LatLng {
        return startAddress
    }

    fun getEndAddress(): LatLng {
        return endAddress
    }

    private fun latLngToLocation(latLng: LatLng): Location {
        return Location(LocationManager.GPS_PROVIDER).apply {
            latitude = latLng.latitude
            longitude = latLng.longitude
        }
    }
}