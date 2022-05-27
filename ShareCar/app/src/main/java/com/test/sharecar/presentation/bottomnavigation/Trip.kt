package com.test.sharecar.presentation.bottomnavigation

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TripScreen(navController: NavController) {
    val context = LocalContext.current
    val backdropState = rememberBackdropScaffoldState(BackdropValue.Revealed)
    val scope = rememberCoroutineScope()
    val viewModel = TripViewModel(context.applicationContext as Application)

    BackdropScaffold(
        scaffoldState = backdropState,
        backLayerContentColor = Color.Black,
        headerHeight = 0.dp,
        appBar = { TitleText(text = "Enter Trip Details", padding = 20, Color.White) },
        backLayerContent = {
            BackdropLayer(navController, backdropState, viewModel, context)
        },
        frontLayerContent = {
            DropDownMenu(scope, backdropState)
        }
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BackdropLayer(
    navController: NavController,
    backdropState: BackdropScaffoldState,
    viewModel: TripViewModel,
    context: Context
) {
    val scope = rememberCoroutineScope()
    val date = viewModel.time.observeAsState(String())
    var destination by remember { mutableStateOf("") }
    var geocoderResults = mutableListOf<String>()
    var suggestionClicked by remember { mutableStateOf(false) }
    var addressSuggestion by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .background(Color.White)
            .padding(20.dp)
            .fillMaxSize(),
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
        TripBookRow(
            onSelectClick = { viewModel.selectDateTime(context) },
            title = "Book a date",
            selection = date.value,
            buttonTitle = "Select date",
            image = Icons.Filled.CalendarToday
        )
        TripBookRow(
            onSelectClick = { scope.launch { backdropState.conceal() } },
            title = "Book a time",
            selection = "",
            buttonTitle = "Select time",
            image = Icons.Filled.Schedule
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
                viewModel.storeTrip(destination, date.value, context)
                navController.navigate(Screen.ConfirmTrip.route)
            }
        ) {
            Text(text = "Confirm", color = Color.White)
        }
        Spacer(modifier = Modifier.padding(bottom = 50.dp))
    }
}

@Composable
fun TripBookRow(
    onSelectClick: () -> Unit,
    title: String,
    buttonTitle: String,
    selection: String,
    image: ImageVector

) {
    LightGreyDivider()
    Text(text = title)
    Row(
        Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        DefaultButton(
            text = buttonTitle,
            onClick = onSelectClick
        )
        Spacer(modifier = Modifier.padding(30.dp))
        Icon(imageVector = image, contentDescription = buttonTitle)
        BoldText(text = selection)
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DropDownMenu(scope: CoroutineScope, backdropState: BackdropScaffoldState) {

    var expanded by remember { mutableStateOf(false) }
    val suggestions = listOf(
        "9 AM", "10 AM", "11 AM", "12 PM", "1 PM",
        "2 PM", "3 PM", "4 PM", "5 PM"
    )
    var bookedTime = "1 PM"
    var selectedText by remember { mutableStateOf("") }
    val context = LocalContext.current
    var textFieldSize by remember { mutableStateOf(Size.Zero) }
    val icon = if (expanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

    Column(Modifier.padding(20.dp, 5.dp, 20.dp, 20.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            IconButton(
                onClick = { scope.launch { backdropState.reveal() } }) {
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = "hide_front_layer"
                )
            }

        }
        OutlinedTextField(
            value = selectedText,
            onValueChange = { selectedText = it },
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    //This value is used to assign to the DropDown the same width
                    textFieldSize = coordinates.size.toSize()
                },
            label = { Text("Select Time") },
            trailingIcon = {
                Icon(icon, "contentDescription",
                    Modifier.clickable { expanded = !expanded })
            }
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current) { textFieldSize.width.toDp() })
        ) {
            suggestions.forEach { timeLabel ->
                DropdownMenuItem(onClick = {
                    if (timeLabel == bookedTime) {
                        //display error message to user
                        Toast.makeText(context, "This time is not available", Toast.LENGTH_LONG)
                            .show()
                    } else {
                        selectedText = timeLabel
                        expanded = false
                    }
                }) {
                    menuItemText = if (timeLabel == bookedTime) {
                        Text(text = timeLabel, color = Color.LightGray)
                    } else Text(text = timeLabel)

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






