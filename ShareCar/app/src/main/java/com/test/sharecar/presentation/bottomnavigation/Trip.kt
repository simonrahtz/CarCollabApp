package com.test.sharecar.presentation.bottomnavigation

import android.app.Application
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.test.sharecar.CustomGeoCoder
import com.test.sharecar.Screen
import com.test.sharecar.components.*


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TripScreen(navController: NavController) {

    val context = LocalContext.current
    val viewModel = TripViewModel(context.applicationContext as Application)
    val dateTime = viewModel.time.observeAsState(String())
    var destination by remember { mutableStateOf("") }
    var geocoderResults = mutableListOf<String>()
    var suggestionClicked by remember { mutableStateOf(false) }
    var addressSuggestion by remember { mutableStateOf("") }

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
                    onTextChange = {
                        destination = it
                    },
                    onClickCancel = {
                        suggestionClicked = true
                        destination = ""
                    })
                // Start Search for addresses when the input string is more than 10 characters
                if (destination.length > 10) {
                    geocoderResults =
                        CustomGeoCoder(context).getAddressStrings(destination).toMutableList()
                }
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    //reset list when clicked
                    if (suggestionClicked) {
                        geocoderResults.clear()
                        addressSuggestion = ""
                        suggestionClicked = false
                    }
                    items(geocoderResults) { address ->
                        if (address != "error") {
                            addressSuggestion = address
                        }
                        Box(
                            modifier = Modifier
                                .padding(10.dp)
                                .clickable(onClick = {
                                    suggestionClicked = true
                                    destination = addressSuggestion

                                })
                        ) {
                            Text(text = addressSuggestion)
                        }
                    }
                }
                LightGreyDivider(padding = 20)
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
                LightGreyDivider(padding = 50)
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
    //DropDownMenu()
}






