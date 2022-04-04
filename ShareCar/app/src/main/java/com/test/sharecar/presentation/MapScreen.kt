package com.test.sharecar.presentation

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

@Composable
fun MapScreen() {
    Scaffold {

        val destination = LatLng(-33.832990, 151.241040)
        val cameraPositionState = rememberCameraPositionState {
            position = CameraPosition.fromLatLngZoom(destination,15f)
        }


        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            properties = MapProperties(),
            uiSettings = MapUiSettings(zoomControlsEnabled = true),
            cameraPositionState = cameraPositionState,

            ){

        }

    }
}

@Composable
@Preview(showBackground = true)
fun MapScreenPreview() {
        MapScreen()
    }