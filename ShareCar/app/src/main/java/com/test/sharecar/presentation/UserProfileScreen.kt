package com.test.sharecar.presentation


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
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
fun UserProfile() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0, 0, 0, 10))
        ) {
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.width(12.dp))
                Image(
                    painter = painterResource(id = R.drawable.ic_user_nav),
                    contentDescription = "avatar",
                    modifier = Modifier
                        .height(60.dp)
                        .width(60.dp)
                        .clip(shape = RoundedCornerShape(50))
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = "Name",
                    color = Color.Black,
                    fontSize = 26.sp
                )

            }
            Row(modifier = Modifier.fillMaxWidth()) {
                Spacer(modifier = Modifier.width(84.dp))
                Text(
                    text = "Log Out",
                    color = Color(185, 155, 248)
                )
                Spacer(modifier = Modifier.width(24.dp))
                Text(
                    text = "Manage Users",
                    color = Color(185, 155, 248)
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
        }
        Spacer(modifier = Modifier.height(6.dp))
        Row(modifier = Modifier.padding(0.dp, 0.dp, 6.dp, 0.dp)) {
            Text(
                text = "Home Address",
                color = Color.Black,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.width(260.dp))
        }
        InfoItem(title = "Street", info = "66 Marloo Street")
        InfoItem(title = "Suburb", info = "Rosslyn Pork")
        InfoItem(title = "Post Code", info = "2784")
        Spacer(
            modifier = Modifier
                .height(6.dp)
                .fillMaxWidth()
                .background(Color(0, 0, 0, 10))
        )
        Row(
            modifier = Modifier.padding(6.dp, 6.dp, 6.dp, 0.dp)
        ) {
            Text(
                text = "Personal Details",
                color = Color.Black,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.width(260.dp))
        }
        InfoItem(title = "Email", info = "jennovoross@gltrrf.com")
        InfoItem(title = "Phone Number", info = "0473 032 934")
        Spacer(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .background(Color(0, 0, 0, 10))
        )
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

@Composable
@Preview
fun UserProfilePreview() {
    UserProfile()
}