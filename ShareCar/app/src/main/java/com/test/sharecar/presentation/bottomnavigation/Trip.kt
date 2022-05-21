package com.test.sharecar.presentation.bottomnavigation

import android.location.Address
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.test.sharecar.GeoCoder
import com.test.sharecar.components.*


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TripScreen(navController: NavController) {

    val context = LocalContext.current
    val viewModel: TripViewModel = viewModel()
    val dateTime = viewModel.time.observeAsState(String())
    var destination by remember { mutableStateOf("") }
    var geocoderResults = mutableListOf<Address>()
    var listState: LazyListState = rememberLazyListState()
    var suggestionClicked by remember { mutableStateOf(false) }

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
                CustomTextField(title = "Type Address",
                    textState = destination,
                    onTextChange = { destination = it },
                    onClickCancel = {
                        suggestionClicked = false
                        destination = ""
                    })

                // Start Search for addresses when the input string is more than 10 characters
                if (destination.length > 10) {
                    geocoderResults =
                        GeoCoder().getAddressFromString(destination, context).toMutableList()
                }

                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    state = listState
                ) {

                    //reset list when clicked
                    if (suggestionClicked) geocoderResults.clear()
                    items(geocoderResults) { address ->

                        // Custom Address String - street number, street name and suburb
                        var suggestion =
                            address.subThoroughfare + " " + address.thoroughfare + " " + address.locality
                        Box(
                            modifier = Modifier
                                .padding(10.dp)
                                .clickable(onClick = {
                                    destination = suggestion
                                    suggestionClicked = true

                                })
                        ) {
                            Text(text = suggestion)
                        }
                    }
                }
                Divider(
                    modifier = Modifier.padding(vertical = 20.dp),
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
                        viewModel.storeTrip(destination, dateTime.value, context)
                        //navController.navigate(Screen.ConfirmTrip.route)

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

@Composable
fun DropDownMenu() {

    var expanded by remember { mutableStateOf(false) }
    val suggestions = listOf("1 PM", "2 PM", "3 PM", "4 PM")
    var selectedText by remember { mutableStateOf("") }

    var textfieldSize by remember { mutableStateOf(Size.Zero) }

    val icon = if (expanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown


    Column(Modifier.padding(20.dp)) {
        OutlinedTextField(
            value = selectedText,
            onValueChange = { selectedText = it },
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    //This value is used to assign to the DropDown the same width
                    textfieldSize = coordinates.size.toSize()
                },
            label = { Text("Label") },
            trailingIcon = {
                Icon(icon, "contentDescription",
                    Modifier.clickable { expanded = !expanded })
            }
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current) { textfieldSize.width.toDp() })
        ) {
            suggestions.forEach { label ->
                DropdownMenuItem(onClick = {
                    selectedText = label
                    expanded = false
                }) {
                    Text(text = label)
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun EnterTripDetailsPreview() {
    TripScreen(navController = rememberNavController())
}






