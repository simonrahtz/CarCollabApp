package com.test.sharecar.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.test.sharecar.presentation.bottomnavigation.ui.theme.Purple500

@SuppressLint("UnusedTransitionTargetStateParameter")
@Composable
fun SpinnerView() {

    val context = LocalContext.current
    val viewModel: DateTimePickerViewModel = viewModel()
    val dateTime = viewModel.time.observeAsState()

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.5f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center

            ) {
                Text(
                    text = "Calender Date & Time Picker",
                    fontSize = 20.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(20.dp))

                TextButton(
                    onClick = {
                        viewModel.selectDateTime(context)
                    },
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .background(Purple500)
                        .padding(5.dp)
                ) {
                    Text(text = "Select Date", color = Color.White)
                }

                Spacer(modifier = Modifier.height(10.dp))

                Text(text = dateTime.value ?: "No Time Set")


            }
        }
    }


@Preview(showBackground = true)
@Composable
fun SpinnerViewPreview() {
    SpinnerView()
}






