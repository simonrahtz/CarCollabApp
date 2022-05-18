package com.test.sharecar.presentation.bottomnavigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import com.test.sharecar.Screen
import com.test.sharecar.components.BoldText
import com.test.sharecar.components.CustomTextField
import com.test.sharecar.components.DefaultButton
import com.test.sharecar.components.TitleText


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TripScreen(navController: NavController) {

    val context = LocalContext.current
    val viewModel: TripViewModel = viewModel()
    val dateTime = viewModel.time.observeAsState(String())
    var address by remember { mutableStateOf("") }
    val onAddressTextChange = { text: String -> address = text }


    BackdropScaffold(
        appBar = { },
        backLayerContent = {
            TitleText(text = "Enter Trip Details", padding = 20, Color.White)
        },
        frontLayerContent = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),

                ) {
                Text(text = "Enter Destination")
                CustomTextField(
                    title = "Type Address",
                    textState = address,
                    onTextChange = onAddressTextChange
                )
                Divider(
                    modifier = Modifier.padding(vertical = 50.dp),
                    color = Color.LightGray
                )
                Text(text = "Book a date")
                Row(
                    Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    DefaultButton(text = "Select Date",
                        onClick = { viewModel.selectDateTime(context) })
                    Spacer(modifier = Modifier.padding(30.dp))
                    BoldText(text = "Date: " + dateTime.value)
                }
                Divider(
                    modifier = Modifier.padding(vertical = 50.dp),
                    color = Color.LightGray
                )
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
                        viewModel.storeTrip(address,dateTime.value,context)
                        navController.navigate(Screen.ConfirmTrip.route)

                    }
                ) {
                    Text(text = "Confirm", color = Color.White)
                }
                Spacer(modifier = Modifier.padding(bottom = 50.dp))

            }
        },
        peekHeight = 100.dp
    ) { }
}



@Preview(showBackground = true)
@Composable
fun EnterTripDetailsPreview() {
    TripScreen(navController = rememberNavController())

}






