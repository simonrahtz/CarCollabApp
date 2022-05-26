package com.test.sharecar.presentation.bottomnavigation

import android.graphics.Color.red
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.test.sharecar.R
import com.test.sharecar.components.TitleText

@Composable
fun CarScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(137, 86, 239))
    ) {
        Text(
            text = "View Car",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            modifier = Modifier.padding(21.dp, 21.dp)
        )
        MainCarBox()
    }
}

@Composable
fun MainCarBox() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(24.dp, 24.dp, 0.dp, 0.dp))
            .background(Color.White)
    ) {
        Spacer(modifier = Modifier.height(12.dp))
        DisplayBox()
        DetailBox()
    }
}

@Composable
fun DetailBox() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp, 0.dp)
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "2005 Mercedes-Benz cla-class",
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )
        Row(modifier = Modifier.height(30.dp), verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.ic_location),
                contentDescription = "location",
                modifier = Modifier
                    .width(24.dp)
                    .height(24.dp)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Column {
                Text(text = "17 Brooker Street St Marys", color = Color.DarkGray)
                Spacer(
                    modifier = Modifier
                        .height(1.dp)
                        .width(165.dp)
                        .background(Color.DarkGray)
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color(0, 0, 0, 20))
        )
        Spacer(modifier = Modifier.height(12.dp))
        DataBox()
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color(0, 0, 0, 20))
        )
        Spacer(modifier = Modifier.height(12.dp))
        Row(modifier = Modifier.height(30.dp), verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.ic_dollar),
                contentDescription = "rate",
                modifier = Modifier
                    .width(24.dp)
                    .height(24.dp)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Row {
                Text(text = "Rate:", color = Color.Gray)
                Spacer(modifier = Modifier.width(6.dp))
                Text(text = "$5.50 per hour + fuel", color = Color.DarkGray, fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
fun DataBox() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .padding(24.dp, 12.dp, 24.dp, 0.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "About this vehicle",
            color = Color.DarkGray,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            Text(text = "Fuel/100kms:", color = Color.Gray)
            Spacer(modifier = Modifier.width(15.dp))
            Text(text = "8.2L", color = Color.DarkGray, fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            Text(text = "Transmission:", color = Color.Gray)
            Spacer(modifier = Modifier.width(12.dp))
            Text(text = "Automatic", color = Color.DarkGray, fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            Text(text = "Kms driven:", color = Color.Gray)
            Spacer(modifier = Modifier.width(26.dp))
            Text(text = "180,954", color = Color.DarkGray, fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            Text(text = "Fuel type:", color = Color.Gray)
            Spacer(modifier = Modifier.width(42.dp))
            Text(text = "Unleaded", color = Color.DarkGray, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun DisplayBox() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(185.dp)
            .clip(RoundedCornerShape(8.dp, 8.dp, 8.dp, 8.dp))
            .background(Color.DarkGray)
    ) {
        Spacer(modifier = Modifier.weight(0.1f))
        Image(painter = painterResource(id = R.drawable.car_display), contentDescription = "car")
        Spacer(modifier = Modifier.weight(0.1f))
    }
}

@Composable
@Preview
fun CarScreenPreiew() {
    CarScreen()
}