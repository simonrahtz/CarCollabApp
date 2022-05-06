package com.test.sharecar.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.test.sharecar.components.BoldText
import com.test.sharecar.components.CustomTextField
import com.test.sharecar.components.DefaultButton
import com.test.sharecar.components.TitleText
import com.test.sharecar.data.Trip


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun EnterTripDetails(navController: NavController) {

    val context = LocalContext.current
    val viewModel: DateTimePickerViewModel = viewModel()
    val dateTime = viewModel.time.observeAsState()
    var address by remember { mutableStateOf("") }
    val onAddressTextChange = { text: String -> address = text }


    BackdropScaffold(
        appBar = { },
        backLayerContent = {
            TitleText(text = "Enter Trip Details", padding = 20)
        },
        frontLayerContent = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),

                ) {
                CustomTextField(
                    title = "Type Address",
                    textState = address,
                    onTextChange = onAddressTextChange
                )
                Divider(
                    modifier = Modifier.padding(vertical = 30.dp),
                    color = Color.LightGray
                )
                Row(
                    Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    DefaultButton(text = "Select Date",
                        onClick = { viewModel.selectDateTime(context) })
                    Spacer(modifier = Modifier.padding(30.dp))
                    BoldText(text = "Date: " + dateTime.value)
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                verticalArrangement = Arrangement.Bottom
            ) {
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    onClick = {
                        viewModel.insertTrip(
                            Trip(
                                0,
                                dateTime.value.toString(),
                                address

                            )
                        )
                        navController.navigate("confirm_trip")
                    }
                ) {
                    Text(text = "Confirm", color = Color.White)
                }

            }
        },
        peekHeight = 100.dp
    ) { }
}


@Preview(showBackground = true)
@Composable
fun EnterTripDetailsPreview() {
    EnterTripDetails(navController = rememberNavController())
}






