package com.test.sharecar.presentation.fragments

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.test.sharecar.R

@Composable
fun UserScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(48.dp))
        Image(
            painter = painterResource(id = R.drawable.ic_user),
            contentDescription = "avatar",
            modifier = Modifier
                .height(120.dp)
                .width(120.dp)
                .clip(shape = RoundedCornerShape(50))
                .background(Color.LightGray)
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = "username",
            color = Color.Black,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(6.dp))
        Table()
    }
}

@Composable
fun Table() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Spacer(
            modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
                .background(Color.DarkGray)
        )
        Row() {
            Text(
                text = "Cars",
                modifier = Modifier
                    .weight(1f)
                    .padding(6.dp),
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.weight(3f))
            Text(
                text = "Bookings",
                modifier = Modifier
                    .weight(1f)
                    .padding(6.dp),
                fontSize = 16.sp
            )
        }
        Spacer(
            modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
                .background(Color.DarkGray)
        )

        val scrollState = rememberLazyListState()
        LazyColumn(state = scrollState) {

        }
    }
}


@Composable
@Preview
fun UserScreenPreview() {
    UserScreen()
}