package com.test.sharecar.presentation.bottomnavigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.test.sharecar.R

@Composable
fun UserScreen() {

    val username = "Username"

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.ic_user),
                contentDescription = "avatar",
                modifier = Modifier
                    .height(80.dp)
                    .width(80.dp)
                    .clip(shape = RoundedCornerShape(50))
                    .background(Color.LightGray)
            )
            Text(text = username,
                modifier = Modifier.padding(20.dp),
                style = MaterialTheme.typography.h5
            )
            Spacer(Modifier.weight(1f))
            Text(text = "Manage \nUsers",
                modifier = Modifier
                    .padding(10.dp),

                style = MaterialTheme.typography.body2
            )
        }
        Divider(modifier = Modifier
            .background(Color.LightGray))

    }
}




@Composable
@Preview(showBackground = true)
fun UserScreenPreview() {
    UserScreen()
}