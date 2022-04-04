package com.test.sharecar.models

import android.location.Address
import android.location.Location
import com.google.android.gms.maps.model.LatLng

class Trip (
    val tripId: Int,
    val startAddress: Address,
    val endAddress: Address

        ) {

    private fun calculateDistance (startLocation: Location, endLocation: Location) :Float {
        return startLocation.distanceTo(endLocation)
    }
}