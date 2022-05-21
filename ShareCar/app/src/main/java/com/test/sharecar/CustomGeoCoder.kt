package com.test.sharecar

import android.content.Context
import android.location.Address
import android.location.Geocoder
import android.location.Location
import com.google.android.gms.maps.model.LatLng
import java.util.*
import kotlin.math.roundToInt

class CustomGeoCoder(context: Context) {
    val context = context

    fun getLatLng(address: String): LatLng {
        var geocoder = Geocoder(context,Locale.getDefault()).getFromLocationName(
            address, 1
        )
        return LatLng(geocoder[0].latitude, geocoder[0].longitude)
    }

    fun getAddress(address: String): Address {

        val addresses = Geocoder(context).getFromLocationName(
            address, 1
        )
        return addresses[0]
    }

    fun getAddressFromString(address: String): List<Address>{

        return Geocoder(context, Locale.getDefault()).getFromLocationName(
            address, 100
        )

    }

    fun getDistance(startAddress: String, endAddress: String): Float {
        val start = getAddress(startAddress)
        val end = getAddress(endAddress)
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