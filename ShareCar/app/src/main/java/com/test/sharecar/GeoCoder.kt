package com.test.sharecar

import android.content.Context
import android.location.Address
import android.location.Geocoder
import com.google.android.gms.maps.model.LatLng

class GeoCoder {

    fun getLatLng(address: String, context: Context): LatLng {
        var geocoder = Geocoder(context).getFromLocationName(
            address, 1
        )
        return LatLng(geocoder[0].latitude, geocoder[0].longitude)
    }

    fun getAddress(address: String, context: Context): Address {

        val addresses = Geocoder(context).getFromLocationName(
            address, 1 )
        return addresses[0]
    }
}