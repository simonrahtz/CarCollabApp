package com.test.sharecar

import android.annotation.SuppressLint
import android.content.ContentProvider
import android.content.Intent
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import androidx.activity.compose.setContent

import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.test.sharecar.R
import com.test.sharecar.presentation.FuelPriceScreen
import com.test.sharecar.presentation.activities.LogInActivity
import com.test.sharecar.presentation.activities.SpinnerViewModel
import com.test.sharecar.presentation.bottomnavigation.ui.theme.Purple500


class MainActivity() : AppCompatActivity(), Parcelable {


    constructor(parcel: Parcel) : this() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startActivity(Intent(this, LogInActivity::class.java))

    }


    @SuppressLint("UnusedTransitionTargetStateParameter")
    @Composable
    fun SpinnerView() {
        val sampleList = mutableListOf("Sample 1", "Sample 2", "Sample 3", "Sample 4", "Sample 5")
        var sampleName: String by remember { mutableStateOf(sampleList[0]) }
        var expanded by remember { mutableStateOf(false) }
        val transitionState = remember {
            MutableTransitionState(expanded).apply {
                targetState = !expanded
            }
        }
        val transition = updateTransition(targetState = transitionState, label = "transition")
        val arrowRotationDegree by transition.animateFloat({
            tween(durationMillis = 300)
        }, label = "rotationDegree") {
            if (expanded) 180f else 0f
        }
        val context = LocalContext.current
        val viewModel: SpinnerViewModel = viewModel()
        val dateTime = viewModel.time.observeAsState()

        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Purple500)
                    .padding(15.dp)
            ) {
                Text(
                    text = "Spinner & DateTime",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Column {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.5f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Spinner",
                        fontSize = 20.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        modifier = Modifier
                            .clickable {
                                expanded = !expanded
                            }
                            .padding(8.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = sampleName,
                            fontSize = 18.sp,
                            modifier = Modifier
                                .padding(end = 8.dp)
                                .height(30.dp)
                        )
                        Icon(
                            imageVector = Icons.Filled.ArrowDropDown,
                            contentDescription = "Spinner",
                            modifier = Modifier.rotate(arrowRotationDegree)
                        )

                        DropdownMenu(
                            expanded = expanded,
                            onDismissRequest = {
                                expanded = false
                            }
                        ) {
                            sampleList.forEach { data ->
                                DropdownMenuItem(
                                    onClick = {
                                        expanded = false
                                        sampleName = data
                                    }
                                ) {
                                    Text(text = data)
                                }
                            }
                        }
                    }
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.5f),
                    horizontalAlignment = Alignment.CenterHorizontally
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
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainActivity> {
        override fun createFromParcel(parcel: Parcel): MainActivity {
            return MainActivity(parcel)
        }

        override fun newArray(size: Int): Array<MainActivity?> {
            return arrayOfNulls(size)
        }
    }
}


