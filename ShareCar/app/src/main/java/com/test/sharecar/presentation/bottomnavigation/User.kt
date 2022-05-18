package com.test.sharecar.presentation.bottomnavigation

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.test.sharecar.R
import com.test.sharecar.Screen
import com.test.sharecar.presentation.HorizontalDivider

@Composable
fun UserScreen(navController: NavController) {

    val username = "Username"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(211, 60, 171)),

        ) {

        TopBar(navController)
        Spacer(modifier = Modifier.height(36.dp))
        TripInfo()
    }
}

@Composable
fun TripInfo() {
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
        TripItem(title = "8 Parkwood Street", date = "04.03.22", distance = "4.1kms")
        Spacer(modifier = Modifier.height(12.dp))
        TripItem(title = "8 Parkwood Street", date = "04.03.22", distance = "4.1kms")
        Spacer(modifier = Modifier.height(12.dp))
        TripItem(title = "8 Parkwood Street", date = "04.03.22", distance = "4.1kms")
    }
}

@Composable
fun TopBar(navController: NavController) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Hello Simon",
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
                painter = painterResource(id = R.drawable.ic_user_trip), contentDescription = "",
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
fun TripItem(title: String, date: String, distance: String) {
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
                .background(
                    Color(0, 0, 0, 20)
                )
                .padding(8.dp, 8.dp, 8.dp, 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = title,
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(text = date, color = Color.DarkGray, fontSize = 16.sp)
                Text(text = distance, color = Color.DarkGray, fontSize = 16.sp)
            }
        }
        Spacer(modifier = Modifier.weight(0.05f))

    }
}