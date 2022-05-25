package com.test.sharecar

import android.content.Context
import android.location.Address
import android.location.Geocoder
import android.location.Location
import androidx.compose.runtime.mutableStateOf
import com.google.android.gms.maps.model.LatLng
import java.util.*
import kotlin.math.roundToInt

class CustomGeoCoder(context: Context) {
    val context = context

    fun getLatLng(address: String): LatLng {
        var geocoder = Geocoder(context, Locale.getDefault()).getFromLocationName(
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

    fun getAddressStrings(address: String): List<String> {
        var result = ""
        var addressStrings = mutableListOf<String>()
        val addresses = Geocoder(context, Locale.getDefault()).getFromLocationName(
            address, Int.MAX_VALUE
        )
        if (addresses.none { it.countryName == "Australia" }) {
            addressStrings.add("error")
        } else {
            addresses.forEach() {
                result = it.getAddressLine(0).replace("Australia"," ")
                addressStrings.add(result)
                    //.add("${it.subThoroughfare} ${it.thoroughfare} ${it.adminArea} ${it.locality} ${it.postalCode}")
            }
        }
        return addressStrings
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

        var distance = startLocation.distanceTo(endLocation)
        distance = (distance / 1000)

        return distance

    }

}