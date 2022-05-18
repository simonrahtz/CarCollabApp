package com.test.sharecar.presentation

import android.app.Application
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Cancel
import androidx.compose.material.icons.sharp.Cancel
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.test.sharecar.components.TitleText
import com.test.sharecar.data.Trip

@Composable
fun ConfirmTripDetails(navController: NavHostController) {

    val context = LocalContext.current
    val viewModel =
        ConfirmTripViewModel(context.applicationContext as Application)
    val latestTripEntry by viewModel.latestTrip.observeAsState(Trip())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.primary)

    ) {
        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TitleText(text = "View Your Trip", padding = 0, Color.White)
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    Icons.Sharp.Cancel,
                    contentDescription = "cancel",
                    tint = Color.White
                )
            }

        }
        Spacer(modifier = Modifier.padding(5.dp))
        Column(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(5.dp))
                .background(Color.White)
                .border(1.dp, Color.LightGray, RoundedCornerShape(5.dp))
                .padding(20.dp)
                .fillMaxSize()


        ) {

            Spacer(
                modifier = Modifier
                    .padding(bottom = 40.dp)
            )

            //InfoItem(title = "Date", info = latestTripEntry.date)
            Spacer(
                modifier = Modifier
                    .height(20.dp)
            )
            InfoItem(
                title = "distance",
                info = viewModel.calculateDistance("8 Parkwood street, Plumpton", context)
                    .toString()

            )

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
                maxLines = 2
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
    ConfirmTripDetails(navController = rememberNavController())
}