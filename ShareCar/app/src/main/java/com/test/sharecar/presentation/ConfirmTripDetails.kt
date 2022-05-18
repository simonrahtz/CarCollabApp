package com.test.sharecar.presentation

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.textInputServiceFactory
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.test.sharecar.R
import com.test.sharecar.data.Trip


@Composable
fun ConfirmTripDetails(navController: NavController) {

    val context = LocalContext.current
    val viewModel =
        ConfirmTripViewModel(context.applicationContext as Application)
    val latestTripEntry by viewModel.latestTrip.observeAsState(Trip())
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color(81, 81, 223, 255))
    ) {
        Spacer(
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
        )
        MainContent()
    }
}

@Composable
fun MainContent() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(24.dp, 24.dp, 0.dp, 0.dp))
            .fillMaxHeight()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Trip Details",
            fontSize = 28.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(24.dp)
        )
        HorizontalDivider()
        Spacer(modifier = Modifier.height(24.dp))
        ImageItem(title = "DESTINATION", content = "PLUMPTON", R.drawable.ic_location_trip)
        Spacer(modifier = Modifier.height(12.dp))
        ImageItem(title = "DATE", content = "04/05/22", R.drawable.ic_date_trip)
        Spacer(modifier = Modifier.height(12.dp))
        ImageItem(title = "CAR", content = "MAZDA 626", R.drawable.ic_car_trip)
        Spacer(modifier = Modifier.height(30.dp))
        TextItem(title = "Distance", content = "48km")
        HorizontalDivider()
        Spacer(modifier = Modifier.height(32.dp))
        TextItem(title = "Petrol Price", content = "$1.67")
        Spacer(modifier = Modifier.height(48.dp))
        TextBoldItem(title = "TOTAL", content = "$22.50")
        Spacer(modifier = Modifier.height(12.dp))
        ButtonItem()
    }
}

@Composable
fun ButtonItem() {
    Row(modifier = Modifier.fillMaxWidth()) {
        Spacer(modifier = Modifier.weight(0.05f))
        Button(
            content = { Text(text = "Confirm") },
            onClick = { /* no-op */ },
            modifier = Modifier
                .weight(0.9f)
                .height(48.dp),
        )
        Spacer(modifier = Modifier.weight(0.05f))
    }
}

@Composable
fun ImageItem(title: String, content: String, image: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
    ) {
        Spacer(modifier = Modifier.weight(0.05f))
        Row(
            modifier = Modifier
                .weight(0.9f)
                .height(80.dp)
                .clip(RoundedCornerShape(8.dp, 8.dp, 8.dp, 8.dp))
                .background(Color(0, 0, 0, 10)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.width(6.dp))
            Image(
                painter = painterResource(id = image),
                contentDescription = "",
                modifier = Modifier
                    .height(50.dp)
                    .width(30.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()

            ) {
                Spacer(modifier = Modifier.height(12.dp))
                Text(text = title, color = Color.Black, fontSize = 14.sp)
                Text(
                    text = content,
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )

            }
        }
        Spacer(modifier = Modifier.weight(0.05f))

    }
}

@Composable
fun TextItem(title: String, content: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(35.dp)
    ) {
        Spacer(modifier = Modifier.weight(0.05f))
        Text(
            text = title, color = Color.Black, fontSize = 18.sp,
            modifier = Modifier.weight(0.3f)
        )
        Spacer(modifier = Modifier.weight(0.4f))
        Text(
            text = content, color = Color.Black, fontSize = 18.sp,
            modifier = Modifier.weight(0.2f)
        )
        Spacer(modifier = Modifier.weight(0.05f))
    }
}

@Composable
fun TextBoldItem(title: String, content: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(35.dp)
    ) {
        Spacer(modifier = Modifier.weight(0.05f))
        Text(
            text = title, fontWeight = FontWeight.Bold, color = Color.Black, fontSize = 20.sp,
            modifier = Modifier.weight(0.3f)
        )
        Spacer(modifier = Modifier.weight(0.4f))
        Text(
            text = content, fontWeight = FontWeight.Bold, color = Color.Black, fontSize = 20.sp,
            modifier = Modifier.weight(0.2f)
        )
        Spacer(modifier = Modifier.weight(0.05f))
    }
}

@Composable
fun HorizontalDivider() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
    ) {
        Spacer(modifier = Modifier.weight(0.05f))
        Spacer(
            modifier = Modifier
                .weight(0.9f)
                .height(1.dp)
                .background(Color(0, 0, 0, 50))
        )
        Spacer(modifier = Modifier.weight(0.05f))
    }
}