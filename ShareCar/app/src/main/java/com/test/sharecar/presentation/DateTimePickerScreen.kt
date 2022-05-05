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
import com.test.sharecar.components.BoldText
import com.test.sharecar.components.CustomTextField
import com.test.sharecar.components.DefaultButton
import com.test.sharecar.data.Trip
import com.test.sharecar.presentation.bottomnavigation.ui.theme.Purple500


@Composable
fun SpinnerView() {

    val context = LocalContext.current
    val viewModel: DateTimePickerViewModel = viewModel()
    val dateTime = viewModel.time.observeAsState()
    var address by remember { mutableStateOf("")}
    val onAddressTextChange = {text : String -> address = text}

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                CustomTextField(title = "Enter Destination",
                    textState = address,
                   onTextChange = onAddressTextChange )
                Spacer(modifier = Modifier
                    .height(20.dp))
                DefaultButton(text = "Select Date",
                    onClick = { viewModel.selectDateTime(context) })
                Spacer(modifier = Modifier
                    .height(10.dp))
                BoldText(text = "Date: " + dateTime.value)
            }
        Spacer(modifier = Modifier
            .height(50.dp))
        Button(
            onClick = {
                viewModel.insertTrip(Trip(0,
                    dateTime.value.toString(),
                    address))
            }

        ) {
            Text(text = "Confirm", color = Color.White)
        }

                }

        }
    


@Preview(showBackground = true)
@Composable
fun SpinnerViewPreview() {
    SpinnerView()
}






