package com.test.sharecar.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun DefaultButton(text: String, onClick: () -> Unit) {
    androidx.compose.material.Button(
        onClick =  onClick

    ) {
        Text(text = text, color = Color.White)
    }
}