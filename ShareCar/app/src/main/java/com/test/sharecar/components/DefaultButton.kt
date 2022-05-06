package com.test.sharecar.components

import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DefaultButton(text: String, onClick: () -> Unit) {
    Button(
        onClick =  onClick,
        modifier = Modifier.height(50.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)

    ) {
        Text(text = text, color = Color.White)
    }
}