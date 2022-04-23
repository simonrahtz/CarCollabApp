package com.test.sharecar.presentation.fragments

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.test.sharecar.R

@Composable
fun BrowserScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
        ) {

        Text(
            text = "Browse Cars",
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            modifier = Modifier.padding(12.dp)
        )

        Column() {
            CarItem(img = R.drawable.mazda_626, name = "Mazda_626")
            CarItem(img = R.drawable.jeep, name = "Jeep Wrangler 2005")
            CarItem(img = R.drawable.ic_car, name = "Honda Integra 2000")
        }
    }
}

@Composable
fun CarItem(img: Int, name: String) {
    Row(modifier = Modifier
        .padding(0.dp, 12.dp,12.dp, )
        .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(img),
            contentDescription = "mazda_626",
            modifier = Modifier
                .width(130.dp)
                .height(130.dp)
        )
        Spacer(modifier = Modifier.width(48.dp))
        Text(text = name,
            fontSize = 18.sp,
            color = Color.Black,

            )
    }
}

@Composable
@Preview
fun BrowserScreenPreview() {
    BrowserScreen()
}