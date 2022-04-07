package com.test.sharecar.presentation

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun FuelPriceScreen() {
    Scaffold() {
        Text(text = "Hello")
    }

    
}

@Preview
@Composable
fun checkFuelPricePreview() {
    FuelPriceScreen()
}