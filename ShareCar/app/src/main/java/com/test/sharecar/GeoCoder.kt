package com.test.sharecar

import android.content.Context
import android.location.Address
import android.location.Geocoder
import android.location.Location
import com.google.android.gms.maps.model.LatLng
import java.util.*
import kotlin.math.roundToInt

class GeoCoder {

    fun getLatLng(address: String, context: Context): LatLng {
        var geocoder = Geocoder(context).getFromLocationName(
            address, 1
        )
        return LatLng(geocoder[0].latitude, geocoder[0].longitude)
    }

    fun getAddress(address: String, context: Context): Address {

        val addresses = Geocoder(context).getFromLocationName(
            address, 1
        )
        return addresses[0]
    }



    fun getDistance(startAddress: String, endAddress: String, context: Context): Float {
        val start = getAddress(startAddress, context)
        val end = getAddress(endAddress, context)
        val startLocation = Location("").apply {
            latitude = start.latitude
            longitude = start.longitude
        }
        val endLocation = Location("").apply {
            latitude = end.latitude
            longitude = end.longitude
        }

        var distance =  startLocation.distanceTo(endLocation)
        distance = (distance/1000)

        return distance

    }

}