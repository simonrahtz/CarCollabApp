package com.test.sharecar.presentation.bottomnavigation

import android.location.Address
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
                        viewModel.storeTrip(address, dateTime.value, context)
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

@Composable
fun SearchQuery() {
    val context = LocalContext.current
    var text by remember { mutableStateOf("") }
    val onTextChange: () -> Unit
    var addresses = listOf<Address>()


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        OutlinedTextField(value = text, onValueChange = {
            text = it
        })
        if (text.length > 5) {
            addresses = GeoCoder().getAddressFromString(text, context)
            Toast.makeText(context,addresses.size,Toast.LENGTH_LONG).show()
        }

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            items(addresses) { address ->
                Box(modifier = Modifier.padding(10.dp)) {
                    Text(text = address.getAddressLine(0))
                }
            }
        }

    }

}

@Preview(showBackground = true)
@Composable
fun EnterTripDetailsPreview() {
    SearchQuery()
}






