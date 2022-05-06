package com.test.sharecar.presentation

import android.app.Application
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ConfirmTripDetails() {

    val viewModel = ConfirmTripDetailsViewModel(LocalContext.current.applicationContext as Application)
    val latestTripEntry by viewModel.latestTrip.observeAsState()

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(10.dp),
    verticalArrangement = Arrangement.Center) {
        latestTripEntry?.let {
            InfoItem(title = "Date", info = it.date!!)
            Spacer(modifier = Modifier
                .height(20.dp))
            InfoItem(title = "Destination", info = it.destination!!)
        }

        }

}


@Composable
fun InfoItem(title: String, info: String) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = title, color = Color.Gray,
            modifier = Modifier.padding(horizontal = 12.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 2.dp)
        ) {
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = info,
                color = Color.DarkGray,
                fontSize = 20.sp,
                modifier = Modifier.weight(0.8f),
                maxLines = 1
            )
            Spacer(modifier = Modifier.width(120.dp))

        }

        Spacer(
            modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
                .background(Color(0, 0, 0, 30))
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ConfirmTripDetailsPreview() {
    ConfirmTripDetails()

}