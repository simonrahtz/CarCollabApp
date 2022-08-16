package com.test.sharecar.presentation.bottomnavigation

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.*
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.test.sharecar.CustomGeoCoder
import com.test.sharecar.navigation.Screen
import com.test.sharecar.components.*
import com.test.sharecar.data.Trip
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
            TimeDropDownMenu(scope, backdropState, viewModel)
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
    val date = viewModel.date.observeAsState(String())
    val time = viewModel.time.observeAsState(String())
    var destination by remember { mutableStateOf("") }
    var geocoderResults = mutableListOf<String>()
    var listVisible by remember { mutableStateOf(false) }
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
                listVisible = true
                destination = it
            },
            onClickCancel = {
                listVisible = false
                destination = ""
            })
        // Start Search for addresses when the input string is more than 10 characters
        if (destination.length > 6) {
            geocoderResults =
                CustomGeoCoder(context).getAddressStrings(destination).toMutableList()
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
        ) {
            if (listVisible) {
                //reset list when clicked
                items(geocoderResults) { address ->
                    if (address != "error") {
                        addressSuggestion = address
                    }
                    Box(
                        modifier = Modifier
                            .padding(10.dp)
                            .clickable(onClick = {
                                listVisible = false
                                destination = addressSuggestion
                            })
                    ) {
                        Text(text = addressSuggestion)
                    }
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
            selection = time.value,
            buttonTitle = "Select time",
            image = Icons.Filled.Schedule
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Bottom
        ) {
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Magenta)
                    .height(50.dp),
                onClick = {
                    viewModel.storeTrip(time.value, destination, date.value, context)
                    navController.navigate(Screen.ConfirmTrip.route)
                }
            ) {
                Text(text = "Confirm", color = Color.White)
            }
            Spacer(modifier = Modifier.padding(20.dp))
        }
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
        Icon(imageVector = image, contentDescription = buttonTitle)
        Spacer(modifier = Modifier.padding(5.dp))
        DefaultButton(
            text = buttonTitle,
            onClick = onSelectClick
        )
        Spacer(modifier = Modifier.padding(30.dp))
        BoldText(text = selection)
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TimeDropDownMenu(
    scope: CoroutineScope,
    backdropState: BackdropScaffoldState,
    viewModel: TripViewModel
) {
    var expanded by remember { mutableStateOf(false) }
    val timeList = viewModel.timeList
    var selectedTime by remember { mutableStateOf("Select") }
    var isMorning by remember { mutableStateOf(false) }
    var pickTimeButtonWidth by remember { mutableStateOf(Size.Zero) }
    val icon = if (expanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown
    val dayHour = if (isMorning) {
        "AM"
    } else {
        "PM"
    }

    Column(Modifier.padding(20.dp, 5.dp, 20.dp, 20.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Divider(
                modifier = Modifier
                    .width(100.dp)
                    .padding(vertical = 10.dp)
                    .height(5.dp),
                color = Color.LightGray
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Button(
                modifier = Modifier
                .weight(0.2f)
                .height(50.dp)
                .onGloballyPositioned { coordinates ->
                    pickTimeButtonWidth = coordinates.size.toSize()
                },
                border = BorderStroke(1.dp, Color.DarkGray),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                onClick = {
                    expanded = !expanded
                }) {
                Text(text = selectedTime, fontSize = 20.sp, textAlign = TextAlign.Left)
                Spacer(modifier = Modifier.padding(30.dp))
                Icon(icon, "contentDescription")
            }
            Button(modifier = Modifier
                .weight(0.1f)
                .height(50.dp),
                border = BorderStroke(1.dp, Color.DarkGray),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                onClick = { isMorning = !isMorning }) {
                Text(text = dayHour)
            }
            Button(modifier = Modifier
                .weight(0.1f)
                .height(50.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
                onClick = {
                    viewModel.updateTime("$selectedTime $dayHour")
                    scope.launch { backdropState.reveal() }
                }) {
                Text(text = "Done", color = Color.White)
            }
        }
        DropDownList(
            items = timeList,
            width = pickTimeButtonWidth,
            expanded = expanded,
            onTimeClick = {
                expanded = false
                selectedTime = it
            })
    }

}

@Composable
fun DropDownList(
    expanded: Boolean,
    onTimeClick: (String) -> Unit,
    width: Size, items: List<String>

) {
    val context = LocalContext.current.applicationContext
    var booked by remember { mutableStateOf(false) }
    val bookedTime = "05:00"
    var height = if (expanded) {
        500
    } else {
        0
    }

    Column(
        modifier = Modifier
            .width(with(LocalDensity.current) { width.width.toDp() })
            .height(height.dp)
            .border(width = 1.dp, color = Color.LightGray)
            .verticalScroll(rememberScrollState())
    ) {
        items.forEach() { item ->
            Box(
                modifier = Modifier
                    .padding(vertical = 10.dp)
                    .padding(start = 20.dp)
                    .clickable(onClick = {
                        if (item == bookedTime) {
                            Toast
                                .makeText(context, "Time not available", Toast.LENGTH_LONG)
                                .show()
                        } else {
                            onTimeClick(item)
                        }
                    })
            ) {
                if(booked){
                    Text(text = item, fontSize = 20.sp,color = Color.Gray)
                }
                else {
                    Text(text = item, fontSize = 20.sp)
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






