package com.test.sharecar.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ConfirmTripDetails() {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(10.dp)) {

        InfoItem(title = "Date", info = "05.04.22")
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
                fontSize = 16.sp,
                modifier = Modifier.weight(0.8f),
                maxLines = 1
            )
            Spacer(modifier = Modifier.width(120.dp))
            Text(
                text = "Edit", color = Color(185, 155, 248),
                modifier = Modifier.weight(0.2f)
            )
        }
        Spacer(modifier = Modifier.height(12.dp))
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