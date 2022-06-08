package com.test.sharecar.presentation

import android.app.Application
import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.test.sharecar.R
import com.test.sharecar.components.CloseIcon
import com.test.sharecar.components.TitleText
import com.test.sharecar.data.Car
import com.test.sharecar.data.Trip


@Composable
fun ConfirmTripDetails(navController: NavController) {

    val context = LocalContext.current.applicationContext
    val viewModel =
        ConfirmTripViewModel(context as Application)
    val latestTripEntry by viewModel.latestTrip.observeAsState(Trip())

    val onCloseClick = {viewModel.deleteTrip(latestTripEntry)
        navController.popBackStack()
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color(81, 81, 223, 255))
    ) {
        Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically) {
            TitleText(text = "Trip estimation", padding = 20, color = Color.White)
            CloseIcon(onIconClick = {viewModel.deleteTrip(latestTripEntry)
                navController.popBackStack()
            },Color.White)

        }
        MainContent(context, viewModel, latestTripEntry, navController)
    }
}

@Composable
fun MainContent(
    context: Context,
    viewModel: ConfirmTripViewModel,
    trip: Trip,
    navController: NavController
) {

    val trip = trip


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
        Spacer(modifier = Modifier.height(10.dp))
        ImageItem(title = "DESTINATION", content = trip.destination, R.drawable.ic_location_trip)
        Spacer(modifier = Modifier.height(10.dp))
        ImageItem(title = "DATE", content = trip.date, R.drawable.ic_date_trip)
        Spacer(modifier = Modifier.height(10.dp))
        ImageItem(title = "CAR", content = Car().name + " " + Car().make, R.drawable.ic_car_trip)
        Spacer(modifier = Modifier.height(10.dp))
        TextItem(
            title = "Distance",
            content = "${trip.distance} km"
        )
        HorizontalDivider()
        Spacer(modifier = Modifier.height(10.dp))
        TextItem(title = "Petrol Price", content = "$1.67")
        Spacer(modifier = Modifier.height(10.dp))
        TextBoldItem(title = "TOTAL", content = "$" + trip.cost)
        Spacer(modifier = Modifier.height(10.dp))
        ButtonItem("Book", onButtonClick = {
            navController.popBackStack()
        })


    }
}

@Composable
fun ButtonItem(
    text: String,
    onButtonClick: () -> Unit
) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Spacer(modifier = Modifier.weight(0.05f))
        Button(
            content = { Text(text = text) },
            onClick = onButtonClick,
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

@Preview
@Composable
fun Preview() {
    ConfirmTripDetails(navController = rememberNavController())
}