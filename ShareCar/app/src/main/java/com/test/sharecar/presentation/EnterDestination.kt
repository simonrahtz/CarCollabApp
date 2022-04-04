package com.test.sharecar.presentation

import android.content.Context
import android.location.Geocoder
import android.location.Location
import android.location.LocationManager
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.maps.model.LatLng

@Composable
fun EnterDestination(navController: NavController){
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ){
        Box(Modifier.padding(bottom = 10.dp)) {
            Text(text = "Enter destination address for your trip",
                style = MaterialTheme.typography.h6)

        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        var text by remember { mutableStateOf("") }
        var location = "8 Parkwood Street, Plumpton"
        var estimatedKms : String
        OutlinedTextField(
            value = location ,
            onValueChange = {},
            enabled = false

        )
        OutlinedTextField(
            value = text ,
            onValueChange = {text = it},
            label = { Text(text = "Enter Address") }
        )


        Button(onClick = {
            //take input address and convert to LatLng, then convert that to Location object
            if(text.isNotEmpty())
            {coordToLocation(geoCoder(text,context))}
            navController.navigate("map")
        },
            modifier = Modifier.padding(top = 20.dp)) {
            Text(text = "Start Trip")

        }

    }

}
fun coordToLocation(latLng: LatLng): Location {
    return Location(LocationManager.GPS_PROVIDER).apply {
        latitude = latLng.latitude
        longitude = latLng.longitude
    }
}

fun geoCoder(address: String, context: Context): LatLng {
    var geocoder = Geocoder(context).getFromLocationName(address
        ,1)
    return LatLng(geocoder[0].latitude,geocoder[0].longitude)
}

@Preview(showBackground = true)
@Composable
fun EnterDestinationPreview() {
        EnterDestination(navController = rememberNavController())
}