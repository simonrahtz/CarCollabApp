package com.test.sharecar.presentation.bottomnavigation

import android.app.Application
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.test.sharecar.R
import com.test.sharecar.navigation.Screen
import com.test.sharecar.data.Trip
import com.test.sharecar.data.User
import com.test.sharecar.presentation.HorizontalDivider

@Composable
fun UserScreen(navController: NavController) {

    val context = LocalContext.current
    val viewModel = UserViewModel(context.applicationContext as Application)
    val user by viewModel.currentUser.observeAsState(User())
    val trips by viewModel.allTrips.observeAsState(listOf())


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(211, 60, 171)),

        ) {

        TopBar(navController, user)
        Spacer(modifier = Modifier.height(36.dp))
        TripInfo(trips,viewModel)
    }
}

@Composable
fun TripInfo(trips: List<Trip>,viewModel: UserViewModel) {


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(24.dp, 24.dp, 0.dp, 0.dp))
            .fillMaxHeight()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Your Trips",
            fontSize = 28.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(12.dp))
        HorizontalDivider()
        Spacer(modifier = Modifier.height(16.dp))

        if (trips.isEmpty()) {
            Text(
                text = "No trips booked",
                modifier = Modifier.padding(20.dp),
                fontSize = 30.sp
            )
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        )
        {
            items(trips) { trip ->
                TripItem(
                    trip = trip,
                    viewModel = viewModel()
                )
            }
        }
    }
}

@Composable
fun TopBar(navController: NavController, user: User) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Hello " + user.name,
            color = Color.White,
            fontSize = 36.sp,
            modifier = Modifier.padding(24.dp, 0.dp, 0.dp, 12.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(36.dp)
        ) {
            Spacer(modifier = Modifier.width(24.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_user_trip),
                contentDescription = "user",
                modifier = Modifier
                    .width(24.dp)
                    .height(24.dp)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = "View Profile",
                color = Color.White,
                fontSize = 18.sp,
                modifier = Modifier.clickable {
                    navController.navigate(Screen.UserProfile.route)
                })
        }
    }
}

@Composable
fun TripItem(trip: Trip,viewModel: UserViewModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(Color(233,233,233))
            .padding(20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(modifier = Modifier.weight(
            0.8f)) {
            Text(
                text = trip.destination,
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(text = trip.date, color = Color.DarkGray, fontSize = 16.sp)
            Text(text = "${trip.distance} kms", color = Color.DarkGray, fontSize = 16.sp)
        }
        Column(modifier = Modifier.weight(
            0.2f)) {
            IconButton(onClick = {
                viewModel.deleteTrip(trip)
            }) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = "delete_trip")
            }
        }


    }
}

@Preview(showBackground = true)
@Composable
fun UserScreenPreview() {

}