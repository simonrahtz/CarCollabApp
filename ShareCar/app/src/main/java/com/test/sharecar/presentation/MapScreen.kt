package com.test.sharecar.presentation

import android.icu.text.CaseMap
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*
import com.test.sharecar.DataCache

@Composable
fun MapScreen() {
    Scaffold {


        val trip = DataCache.currentTrip[0]
        val destination = trip?.getEndAddress()

        val cameraPositionState = rememberCameraPositionState {
            position = destination?.let { it1 -> CameraPosition.fromLatLngZoom(it1,15f) }!!
        }


        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            properties = MapProperties(),
            uiSettings = MapUiSettings(zoomControlsEnabled = true),
            cameraPositionState = cameraPositionState,

            ){
            if (destination != null) {
                Marker(
                    position = destination,
                    title = trip.calculateDistance().toString()
                )
            }



        }

    }
}

@Composable
@Preview(showBackground = true)
fun MapScreenPreview() {
        MapScreen()
    }